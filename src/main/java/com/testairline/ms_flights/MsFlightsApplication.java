/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories
public class MsFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFlightsApplication.class, args);
	}
}
