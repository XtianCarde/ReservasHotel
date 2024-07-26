package com.example.reservas.api.dto.request;

import java.time.LocalDateTime;
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
public class ReservationRequest {
    @NotNull(message = "La fecha de inicio de reserva es necesario")
    private LocalDateTime reservationStart;
    @NotNull(message = "La fecha de fin de reserva es necesario")
    private LocalDateTime reservationEnd;
    @NotNull(message = "El id del cliente es requerido")
    private Long clientId;
    @NotNull(message = "El id de la habitacion es requerido")
    private Long roomId;
}
