package com.esctb.restapiserver.domain.nyang.entitiy;

import com.esctb.restapiserver.domain.model.Gender;
import com.esctb.restapiserver.domain.model.GenderConverter;
import com.esctb.restapiserver.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Nyang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nyang_id")
    private Long id;
    private String name;
    private String favoriteSnack;
    private Integer weight;
    private String breed;
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    private Integer age;
    private String origin;
    private Integer snackAmount;
    private LocalDateTime birthDate;
    private String address;

}
