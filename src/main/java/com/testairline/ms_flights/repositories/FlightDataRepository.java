/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.repositories;

import com.testairline.ms_flights.adapters.FlightRepository;
import com.testairline.ms_flights.documents.FlightDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepository extends MongoRepository<FlightDocument, String>, FlightRepository {
}
