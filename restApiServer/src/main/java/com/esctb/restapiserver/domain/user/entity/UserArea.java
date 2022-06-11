package com.esctb.restapiserver.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_area_mpng")
public class UserArea {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_area_id")
    private Long id;

    //private List<User> userList = new ArrayList<>();
    //private List<Area> areaList = new ArrayList<>();
}
