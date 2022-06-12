package com.esctb.restapiserver.domain.reservation.controller;

import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    @Resource(name = "reservationService")
    private final ReservationService reservationService;

    @GetMapping()
    public Reservation getReservation(Long id){
        return reservationService.getReservation(id);
    }

}
