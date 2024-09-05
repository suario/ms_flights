/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDTO {
	private Long id;

	private String name;
}
