package com.example.reservas.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservas.api.dto.reponse.ReservationBasicResp;
import com.example.reservas.api.dto.request.ReservationRequest;
import com.example.reservas.domain.entities.Reservation;
import com.example.reservas.domain.repositories.ReservationRepository;
import com.example.reservas.infrastructure.abstract_services.IReservationService;
import com.example.reservas.infrastructure.helpers.SupportService;
import com.example.reservas.infrastructure.mappers.ReservationMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    
    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired 
    private final SupportService<Reservation> supportService;
    @Autowired
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationBasicResp create(ReservationRequest rq) {
        return this.reservationMapper.entityToResponse(this.reservationRepository.save(this.reservationMapper.requestToEntity(rq)));
    }

    @Override
    public ReservationBasicResp findById(Long id) {
        return this.reservationMapper.entityToResponse(this.find(id));
    }

    @Override
    public ReservationBasicResp update(ReservationRequest rq, Long id) {
        Reservation reservationUpdate = this.find(id);
        reservationUpdate = this.reservationMapper.requestToEntity(rq);
        reservationUpdate.setId(id);
        return this.reservationMapper.entityToResponse(reservationUpdate);
    }

    @Override
    public void delete(Long id) {
        this.reservationRepository.delete(this.find(id));
    }

    public Reservation find(Long id){
        return this.supportService.findById(reservationRepository, id, "Reserva");
    }
}
