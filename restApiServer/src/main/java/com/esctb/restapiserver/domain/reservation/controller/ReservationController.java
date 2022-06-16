package com.esctb.restapiserver.domain.reservation.controller;

import com.esctb.restapiserver.domain.reservation.dto.ReservationDto;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping()
    public ReservationDto.ReservationResponse getReservation(Long id){
        return reservationService.getReservation(id);
    }

    @GetMapping("products/{product_id}")
    public ReservationDto.ReservationResponse getReservationByProductId(@PathVariable Long product_id){
        return reservationService.getReservationByProductId(product_id);
    }

    @PostMapping()
    public ReservationDto.ReservationResponse saveReservation(@RequestBody ReservationDto.ReservationCreateRequest request){
        return reservationService.saveReservation(request);
    }

}
