package com.esctb.restapiserver.domain.reservation.service;

import com.esctb.restapiserver.domain.reservation.dto.ReservationDto;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.reservation.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private final ReservationRepository reservationRepository;

    @Override
    public ReservationDto.ReservationResponse getReservation(Long id) {
        return ReservationDto.ReservationResponse.builder().build().toReservation(reservationRepository.findById(id).orElse(null));
    }

    @Override
    public ReservationDto.ReservationResponse getReservationByProductId(Long productId) {
        return ReservationDto.ReservationResponse.builder().build().toReservation(
                reservationRepository.findByProductId(productId).orElse(null)
        );
    }

    @Override
    public ReservationDto.ReservationResponse saveReservation(ReservationDto.ReservationCreateRequest request) {
        return ReservationDto.ReservationResponse.builder().build().toReservation(
                reservationRepository.save(request.toReservation())
        );
    }
}
