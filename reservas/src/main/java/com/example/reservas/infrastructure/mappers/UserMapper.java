package com.example.reservas.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import com.example.reservas.api.dto.reponse.UserBasicResp;
import com.example.reservas.api.dto.request.UserRequest;
import com.example.reservas.domain.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "reservations", ignore = true)
    })
    UserEntity requestToEntity(UserRequest request);

    UserBasicResp entityToResp(UserEntity entity);
}
