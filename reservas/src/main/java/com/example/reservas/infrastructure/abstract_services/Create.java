package com.example.reservas.infrastructure.abstract_services;

public interface Create<RQ,RS> {
    RS create(RQ rq);
}
