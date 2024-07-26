package com.example.reservas.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.reservas.domain.entities.Room;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long>{
    Page<Room> findByAvailableTrue(Pageable pageable);
}
