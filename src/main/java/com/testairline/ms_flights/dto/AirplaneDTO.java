/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import java.util.List;
import lombok.Data;

@Data
public class AirplaneDTO {

	private Long id;
	private String name;

	private List<SeatRangeDTO> seatRanges;
}
