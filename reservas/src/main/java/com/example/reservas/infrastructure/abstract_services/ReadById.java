package com.example.reservas.infrastructure.abstract_services;

public interface ReadById<RS,ID> {
    RS findById(ID id);
}
