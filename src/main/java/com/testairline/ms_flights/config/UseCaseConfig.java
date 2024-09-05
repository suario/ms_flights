/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.config;

import com.testairline.ms_flights.adapters.AirportGateway;
import com.testairline.ms_flights.adapters.FlightRepository;
import com.testairline.ms_flights.usecases.GenerateFlightsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

	@Bean
	public GenerateFlightsUseCase createFlightUseCase(FlightRepository flightRepository,
			AirportGateway airportGateway) {
		return new GenerateFlightsUseCase(flightRepository, airportGateway);
	}
}
