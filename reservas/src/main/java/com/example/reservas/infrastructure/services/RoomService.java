package com.example.reservas.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.reservas.api.dto.reponse.RoomBasicResp;
import com.example.reservas.api.dto.request.RoomRequest;
import com.example.reservas.domain.entities.Room;
import com.example.reservas.domain.repositories.RoomRepository;
import com.example.reservas.infrastructure.abstract_services.IRoomService;
import com.example.reservas.infrastructure.helpers.SupportService;
import com.example.reservas.infrastructure.mappers.RoomMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomService implements IRoomService {
    
    @Autowired
    private final RoomRepository roomRepository;
    @Autowired
    private final SupportService<Room> supportService;
    @Autowired
    private final RoomMapper roomMapper;
    
    @Override
    public RoomBasicResp create(RoomRequest rq) {
        return this.roomMapper.entityToResponse(this.roomRepository.save(this.roomMapper.requestToEntity(rq)));
    }

    @Override
    public RoomBasicResp update(RoomRequest rq, Long id) {
        Room roomUpdate = this.find(id);
        roomUpdate = this.roomMapper.requestToEntity(rq);
        roomUpdate.setId(id);
        return this.roomMapper.entityToResponse(this.roomRepository.save(roomUpdate));
    }

    @Override
    public RoomBasicResp findById(Long id) {
        return this.roomMapper.entityToResponse(this.find(id));
    }

    @Override
    public Page<RoomBasicResp> findAvailable(int page, int size) {
        if(page < 0 ) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.roomRepository.findByAvailableTrue(pagination).map(this.roomMapper::entityToResponse);
    }

    @Transactional
    @Override
    public RoomBasicResp isAvailable(Long id) {
        Room roomIsAvailable = this.find(id);
        roomIsAvailable.setAvailable(!roomIsAvailable.getAvailable());
        return this.roomMapper.entityToResponse(roomIsAvailable);
    }
    
    public Room find(Long id){
        return this.supportService.findById(roomRepository, id, "habitación");
    }
}
