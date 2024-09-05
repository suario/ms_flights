/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.scheduler;

import com.testairline.ms_flights.usecases.GenerateFlightsUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class FlightScheduler {

	@Autowired
	private GenerateFlightsUseCase generateFlightsUseCase;

	@Scheduled(cron = "0 */1 * * * *")
	@Transactional
	private void scheduleFutureFlights() {
		generateFlightsUseCase.calculateFlights();
	}
}
