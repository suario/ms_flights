/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import lombok.Data;

@Data
public class SeatClassDTO {
	private Long id;
	private String name;
	private Double basePrice;
}
