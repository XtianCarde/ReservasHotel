package com.example.reservas.api.dto.reponse;

import java.time.LocalDateTime;

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
public class ReservationBasicResp {
    private Long id;
    private LocalDateTime reservationStart;
    private LocalDateTime reservationEnd;
    private UserBasicResp client;
    private RoomBasicResp room;
}
