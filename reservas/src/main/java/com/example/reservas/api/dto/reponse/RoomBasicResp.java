package com.example.reservas.api.dto.reponse;

import com.example.reservas.util.enums.TypeRoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomBasicResp {
    private Long id;
    private String number;
    private TypeRoom type;
    private Boolean available;
}
