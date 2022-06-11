package com.esctb.restapiserver.domain.reservation.service;

import com.esctb.restapiserver.domain.reservation.entity.Reservation;

import java.util.Optional;

public interface ReservationService {
    Reservation getReservation(Long id);
}
