/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.usecases;

import com.testairline.ms_flights.adapters.AirportGateway;
import com.testairline.ms_flights.adapters.FlightRepository;
import com.testairline.ms_flights.documents.Airplane;
import com.testairline.ms_flights.documents.FlightDocument;
import com.testairline.ms_flights.documents.PricedSeatClass;
import com.testairline.ms_flights.dto.ConfigurationWrapperDTO;
import com.testairline.ms_flights.mappers.AirplaneMapper;
import com.testairline.ms_flights.mappers.LocationMapper;
import com.testairline.ms_flights.mappers.SeatClassMapper;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

@Slf4j
public class GenerateFlightsUseCase {

	private final AirplaneMapper airplaneMapper = Mappers.getMapper(AirplaneMapper.class);
	private final LocationMapper locationMapper = Mappers.getMapper(LocationMapper.class);

	private final SeatClassMapper seatClassMapper = Mappers.getMapper(SeatClassMapper.class);

	private final FlightRepository flightRepository;
	private final AirportGateway airportGateway;

	public GenerateFlightsUseCase(FlightRepository flightRepository, AirportGateway airportGateway) {
		this.flightRepository = flightRepository;
		this.airportGateway = airportGateway;
	}

	public void calculateFlights() {
		ConfigurationWrapperDTO configuration = this.airportGateway.getAirportConfiguration();

		LocalTime newDepartureTime = LocalTime.of(8, 0);
		LocalTime newArrivalTime = LocalTime.of(14, 30);

		Map<Long, Airplane> airplaneMap = new ConcurrentHashMap<>(
				configuration.getAirplanes().stream().map(airplaneMapper::convertDTOToDocument)
						.collect(Collectors.toMap(Airplane::getId, Function.identity())));

		List<PricedSeatClass> seatClasses = configuration.getSeatClasses().stream()
				.map(seatClassMapper::convertDTOToDocument).toList();

		ExecutorService executor = Executors.newFixedThreadPool(8);

		configuration.getPlans().forEach(plan -> {
			Runnable runnableTask = () -> {
				long daysBetween = Duration.ofDays(ChronoUnit.DAYS.between(plan.getStartDate(), plan.getEndDate()))
						.toDays();
				var flightBuilder = FlightDocument.builder().airplane(airplaneMap.get(plan.getAirplane().getId()))
						.origin(locationMapper.convertDTOToDocument(plan.getLocation1()))
						.destiny(locationMapper.convertDTOToDocument(plan.getLocation2())).seatClasses(seatClasses);

				for (long daysToAdd = 0; daysToAdd <= daysBetween; daysToAdd++) {
					LocalDate newDate = plan.getStartDate().plusDays(daysToAdd);

					var flight = flightBuilder.departureDate(newDate).departureTime(newDepartureTime)
							.arrivalDate(newDate).arrivalTime(newArrivalTime).build();

					flightRepository.insert(flight);
				}

				log.info("Flight plan executed {}", plan.getId());
			};

			executor.submit(runnableTask);
		});

		executor.shutdown();
	}
}
