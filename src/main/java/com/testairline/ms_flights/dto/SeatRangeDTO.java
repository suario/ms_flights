/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import lombok.Data;

@Data
public class SeatRangeDTO {
	private Long id;

	private Long seatClass;

	private String columnFrom;

	private String columnTo;

	private Integer rowFrom;

	private Integer rowTo;
}
