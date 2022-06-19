package com.esctb.restapiserver.domain.reservation.service;

import com.esctb.restapiserver.domain.product.entity.Product;
import com.esctb.restapiserver.domain.reservation.entity.Reservation;
import com.esctb.restapiserver.domain.reservation.repository.ReservationRepository;
import com.esctb.restapiserver.domain.user.entity.User;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationServiceTest {

    @Autowired
    private ReservationRepository reservationRepository;
    private Reservation reservation;
    private Product product;
    private User user;

    @BeforeEach
    void setReservation(){
        product=Product.builder()
                .id(1L)
                .build();
        user= User.builder()
                .id(1L)
                .build();
        reservation=Reservation.builder()
                .reservationDate(new Date())
                .user(user)
                .product(product)
                .build();
    }

    @Test
    void saveTest(){
        Reservation saveResult=reservationRepository.save(reservation);
        Assertions.assertNotNull(saveResult.getId());
        Assertions.assertEquals(reservation.getReservationDate(), saveResult.getReservationDate());
    }

}