package com.esctb.restapiserver.domain.reservation.service;

import com.esctb.restapiserver.domain.reservation.dto.ReservationDto;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;

import java.util.Optional;

public interface ReservationService {
    ReservationDto.ReservationResponse getReservation(Long id);
    ReservationDto.ReservationResponse getReservationByProductId(Long productId);
    ReservationDto.ReservationResponse saveReservation(ReservationDto.ReservationCreateRequest request);
}
