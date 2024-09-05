/* (C) Jorge Suarez 2024 */
package com.testairline.ms_flights.mappers;

import com.testairline.ms_flights.documents.PricedSeatClass;
import com.testairline.ms_flights.dto.SeatClassDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SeatClassMapper {

	@Mapping(target = "price", source = "basePrice")
	PricedSeatClass convertDTOToDocument(SeatClassDTO dto);
}
