/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.documents;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "flights")
public class FlightDocument implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	public String id;

	private String code;

	private Airplane airplane;

	private LocalDate departureDate;
	private LocalTime departureTime;

	private LocalDate arrivalDate;
	private LocalTime arrivalTime;

	private Location origin;

	private Location destiny;

	private List<PricedSeatClass> seatClasses;
}
