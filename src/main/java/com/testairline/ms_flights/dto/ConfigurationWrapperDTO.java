/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ConfigurationWrapperDTO {

	private final List<SeatClassDTO> seatClasses;

	private final List<AirplaneDTO> airplanes;

	private final List<FlightPlanDTO> plans;
}
