package com.example.reservas.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.example.reservas.api.dto.reponse.UserBasicResp;
import com.example.reservas.api.dto.request.UserRequest;

public interface IUserService extends Create<UserRequest,UserBasicResp>,
                                    Update<UserRequest,UserBasicResp,Long>,
                                    Delete<Long>,
                                    ReadById<UserBasicResp, Long> {
    
    Page<UserBasicResp> findByName(int page, int size, String name);                                    
}
