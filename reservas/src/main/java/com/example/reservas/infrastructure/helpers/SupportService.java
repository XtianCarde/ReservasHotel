package com.example.reservas.infrastructure.helpers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.example.reservas.util.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SupportService<Entity> {
    public Entity findById(JpaRepository<Entity, Long> repository, Long id, String name) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException(String.format("No se encuentra el/la %s por el id suministrado", name)));
    }
}
