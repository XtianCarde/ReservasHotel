package com.example.reservas.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface Read<RS> {
    Page<RS> getAll(int page, int size);
}
