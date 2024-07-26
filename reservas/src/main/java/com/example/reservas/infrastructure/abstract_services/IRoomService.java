package com.example.reservas.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.example.reservas.api.dto.reponse.RoomBasicResp;
import com.example.reservas.api.dto.request.RoomRequest;

public interface IRoomService extends Create<RoomRequest, RoomBasicResp>,
                                        Update<RoomRequest, RoomBasicResp, Long>,
                                        ReadById<RoomBasicResp, Long> {
    Page<RoomBasicResp> findAvailable(int page, int size);
    RoomBasicResp isAvailable(Long id);
}
