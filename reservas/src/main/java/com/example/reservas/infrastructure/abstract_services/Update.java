package com.example.reservas.infrastructure.abstract_services;

public interface Update<RQ, RS, ID> {
    RS update(RQ rq, ID id);
}
