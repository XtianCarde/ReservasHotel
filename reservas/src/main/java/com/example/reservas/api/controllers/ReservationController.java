package com.example.reservas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.api.dto.reponse.ReservationBasicResp;
import com.example.reservas.api.dto.request.ReservationRequest;
import com.example.reservas.infrastructure.abstract_services.IReservationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
@Tag(name = "reservations")
public class ReservationController {
    
    @Autowired
    private final IReservationService reservationService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReservationBasicResp> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.reservationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ReservationBasicResp> create(@Validated @RequestBody ReservationRequest request){
        return ResponseEntity.ok(this.reservationService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ReservationBasicResp> update(@Validated @RequestBody ReservationRequest request, @PathVariable Long id){
        return ResponseEntity.ok(this.reservationService.update(request, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
