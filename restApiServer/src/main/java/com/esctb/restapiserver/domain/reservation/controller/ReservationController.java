package com.esctb.restapiserver.domain.reservation.controller;

import com.esctb.restapiserver.domain.reservation.dto.ReservationDto;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.reservation.service.ReservationService;
import com.esctb.restapiserver.global.common.ApiResponse;
import com.esctb.restapiserver.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public ApiResponse getReservation(@PathVariable Long id){
        return ApiResponse.createSuccess(reservationService.getReservation(id));
    }

    @GetMapping("products/{product_id}")
    public ApiResponse getReservationByProductId(@PathVariable Long product_id){
        try{
            return ApiResponse.createSuccess(reservationService.getReservationByProductId(product_id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @PostMapping()
    public ApiResponse saveReservation(@RequestBody ReservationDto.ReservationCreateRequest request){
        try{
            return ApiResponse.createSuccess(reservationService.saveReservation(request));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteReservation(@PathVariable Long id){
        try{
            return ApiResponse.createSuccess(reservationService.deleteReservation(id));
        }catch (CustomException e){
            return ApiResponse.createError(e.getErrorCode());
        }
    }

}
