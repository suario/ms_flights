/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.client;

import com.testairline.ms_flights.adapters.AirportGateway;
import com.testairline.ms_flights.dto.ConfigurationWrapperDTO;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AirportWebClient implements AirportGateway {

	@Value("${external.service.airport.airport-uri}")
	private String airportServiceURI;

	@Autowired
	private WebClient webClient;

	public ConfigurationWrapperDTO getAirportConfiguration() {
		return webClient.get().uri(uriBuilder -> uriBuilder.pathSegment(airportServiceURI).build())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.acceptCharset(StandardCharsets.UTF_8).retrieve().bodyToMono(ConfigurationWrapperDTO.class).block();
	}
}
