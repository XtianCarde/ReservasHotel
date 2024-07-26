package com.example.reservas.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.reservas.api.dto.reponse.ReservationBasicResp;
import com.example.reservas.api.dto.request.ReservationRequest;
import com.example.reservas.domain.entities.Reservation;
import com.example.reservas.infrastructure.services.RoomService;
import com.example.reservas.infrastructure.services.UserService;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ReservationMapper {
    
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    
    public Reservation requestToEntity(ReservationRequest request){
            if ( request == null ) {
                return null;
            }
    
            Reservation.ReservationBuilder reservation = Reservation.builder();
    
            reservation.reservationEnd( request.getReservationEnd() );
            reservation.reservationStart( request.getReservationStart());
            reservation.client(this.userService.find(request.getClientId()));
            reservation.room(this.roomService.find(request.getRoomId()));
    
            return reservation.build();
        
    };

    abstract public ReservationBasicResp entityToResponse(Reservation reservation);
}
