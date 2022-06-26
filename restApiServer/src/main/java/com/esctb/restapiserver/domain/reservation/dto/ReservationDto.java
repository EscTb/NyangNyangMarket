package com.esctb.restapiserver.domain.reservation.dto;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

public class ReservationDto {

    @NoArgsConstructor
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReservationCreateRequest{
        private Long userId;
        private Long productId;
        private Date reservationDate;

        public Reservation toReservation(){
            return Reservation.builder()
                    .reservationDate(reservationDate)
                    .user(User.builder().id(userId).build())
                    .product(Product.builder().id(productId).build())
                    .build();
        }
    }

    @NoArgsConstructor
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReservationResponse{
        private Long id;
        private Long userId;
        private Long productId;
        private Date reservationDate;

        public ReservationResponse toReservation(Reservation reservation){
            return ReservationResponse.builder()
                    .id(reservation.getId())
                    .userId(reservation.getUser().getId())
                    .productId(reservation.getProduct().getId())
                    .reservationDate(reservation.getReservationDate())
                    .build();
        }
    }
}