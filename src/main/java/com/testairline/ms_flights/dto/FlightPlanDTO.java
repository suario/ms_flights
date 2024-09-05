/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class FlightPlanDTO {
	private Long id;
	private AirplaneDTO airplane;
	private LocationDTO location1;
	private LocationDTO location2;
	private LocalDate startDate;
	private LocalDate endDate;
}
