package com.example.reservas.api.dto.request;

import com.example.reservas.util.enums.TypeRoom;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class RoomRequest {
    @NotBlank(message = "El numero de la habitacion es requerido")
    private String number;
    @Enumerated(EnumType.STRING)
    private TypeRoom type;
    @NotNull(message = "La disponibilidad de habitacion es requerido")
    private Boolean available;
}
