package com.example.reservas.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.reservas.domain.entities.Reservation;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation,Long>{
    
}
