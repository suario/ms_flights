/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.mappers;

import com.testairline.ms_flights.documents.Airplane;
import com.testairline.ms_flights.dto.AirplaneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AirplaneMapper {

	@Mapping(target = "name", source = "name")
	Airplane convertDTOToDocument(AirplaneDTO dto);
}
