/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.adapters;

import com.testairline.ms_flights.documents.FlightDocument;

public interface FlightRepository {
	FlightDocument insert(FlightDocument document);
}
