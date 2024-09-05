/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.documents;

import lombok.Data;

@Data
public class PricedSeatClass {
	public Long id;

	private String name;
	public Double price;
}
