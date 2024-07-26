package com.example.reservas.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.example.reservas.api.dto.reponse.RoomBasicResp;
import com.example.reservas.api.dto.request.RoomRequest;
import com.example.reservas.domain.entities.Room;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "reservations", ignore = true)
    })
    Room requestToEntity(RoomRequest request);

    RoomBasicResp entityToResponse(Room entity);
}
