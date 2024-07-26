package com.example.reservas.infrastructure.abstract_services;

import com.example.reservas.api.dto.reponse.ReservationBasicResp;
import com.example.reservas.api.dto.request.ReservationRequest;

public interface IReservationService extends Create<ReservationRequest, ReservationBasicResp>,
                                                ReadById<ReservationBasicResp, Long>,
                                                Update<ReservationRequest, ReservationBasicResp, Long>,
                                                Delete<Long> {
    
}
