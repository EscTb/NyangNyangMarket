package com.esctb.restapiserver.domain.user.entity;

import com.esctb.restapiserver.domain.user.entity.enums.SuedYn;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    private String password;
    private String name;
    private String email;
    @Embedded
    private Address address;
    private String nickname;
    private int temperature;

    @Column(name = "sued_yn")
    @Enumerated(EnumType.STRING)
    private SuedYn suedYn;

    //private List<Product> products = new ArrayList<>();
}
