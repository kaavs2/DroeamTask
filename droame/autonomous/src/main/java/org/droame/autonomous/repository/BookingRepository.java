package org.droame.autonomous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.droame.autonomous.model.Booking;


@Repository

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
