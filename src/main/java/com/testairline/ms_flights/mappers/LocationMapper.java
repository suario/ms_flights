/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.mappers;

import com.testairline.ms_flights.documents.Location;
import com.testairline.ms_flights.dto.LocationDTO;
import org.mapstruct.Mapper;

@Mapper
public interface LocationMapper {

	Location convertDTOToDocument(LocationDTO dto);
}
