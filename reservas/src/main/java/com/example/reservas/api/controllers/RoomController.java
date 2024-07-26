package com.example.reservas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.api.dto.reponse.RoomBasicResp;
import com.example.reservas.api.dto.request.RoomRequest;
import com.example.reservas.infrastructure.abstract_services.IRoomService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/rooms")
@AllArgsConstructor
@Tag(name = "rooms")
public class RoomController {
    

    @Autowired
    private final IRoomService roomService;

    @GetMapping
    public ResponseEntity<Page<RoomBasicResp>> findAvailable(@RequestParam (defaultValue = "1") int page,
                                                            @RequestParam (defaultValue = "10") int size){
        return ResponseEntity.ok(this.roomService.findAvailable(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RoomBasicResp> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.roomService.findById(id));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<RoomBasicResp> isAvailable(@PathVariable Long id){
        return ResponseEntity.ok(this.roomService.isAvailable(id));
    }

    @PostMapping
    public ResponseEntity<RoomBasicResp> create(@Validated @RequestBody RoomRequest request){
        return ResponseEntity.ok(this.roomService.create(request));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RoomBasicResp> update(@Validated @RequestBody RoomRequest request,@PathVariable Long id){
        return ResponseEntity.ok(this.roomService.update(request, id));
    }
}
