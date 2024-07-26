package com.example.reservas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservas.api.dto.reponse.UserBasicResp;
import com.example.reservas.api.dto.request.UserRequest;
import com.example.reservas.infrastructure.abstract_services.IUserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "users")
public class UserControler {
    
    @Autowired
    private final IUserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserBasicResp> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<UserBasicResp>> findByName(@RequestParam (defaultValue = "1") int page,
    @RequestParam (defaultValue = "10") int size,
    @RequestParam (defaultValue = "") String name){

        return ResponseEntity.ok(this.userService.findByName(page - 1, size, name));
    }

    @PostMapping
    public ResponseEntity<UserBasicResp> create(@Validated @RequestBody UserRequest request){
        return ResponseEntity.ok(this.userService.create(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserBasicResp> update(@PathVariable Long id, @Validated @RequestBody UserRequest request){
        return ResponseEntity.ok(this.userService.update(request, id));
    }

}
