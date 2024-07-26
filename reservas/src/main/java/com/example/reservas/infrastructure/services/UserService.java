package com.example.reservas.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.reservas.api.dto.reponse.UserBasicResp;
import com.example.reservas.api.dto.request.UserRequest;
import com.example.reservas.domain.entities.UserEntity;
import com.example.reservas.domain.repositories.UserRepository;
import com.example.reservas.infrastructure.abstract_services.IUserService;
import com.example.reservas.infrastructure.helpers.SupportService;
import com.example.reservas.infrastructure.mappers.UserMapper;
import com.example.reservas.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final SupportService<UserEntity> supportService;

    @Override
    public UserBasicResp create(UserRequest rq) {
        return this.userMapper.entityToResp(this.userRepository.save(this.userMapper.requestToEntity(rq)));
    }

    @Override
    public UserBasicResp update(UserRequest rq, Long id) {
        UserEntity userUpdate = this.find(id);
        userUpdate = this.userMapper.requestToEntity(rq);
        userUpdate.setId(id);
        return this.userMapper.entityToResp(this.userRepository.save(userUpdate));
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(this.find(id));
    }

    @Override
    public UserBasicResp findById(Long id) {
        return this.userMapper.entityToResp(this.find(id));
    }

    @Override
    public Page<UserBasicResp> findByName(int page, int size, String name) {
        if(page < 0 ) page = 0;

        PageRequest pagination = PageRequest.of(page, size);
        Page<UserEntity> resultPage = userRepository.findByNameContainingIgnoreCase(pagination, name);

        if (resultPage.isEmpty()) {
            throw new BadRequestException(String.format("No se encuentra usuario por el nombre suministrado: %s", name));
        }

        return this.userRepository.findByNameContainingIgnoreCase(pagination, name)
                    .map(this.userMapper::entityToResp);
    }
    
    public UserEntity find(Long id){
        return this.supportService.findById(userRepository, id, "usuario");
    }
}
