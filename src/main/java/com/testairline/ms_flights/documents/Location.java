/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.documents;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {

	public Long id;

	private String name;
}
