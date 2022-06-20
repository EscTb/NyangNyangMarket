package com.esctb.restapiserver.domain.user.entity;

import com.esctb.restapiserver.domain.user.dto.UserDto.*;
import com.esctb.restapiserver.domain.user.entity.enums.SuedYn;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
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
    private Double temperature;

    @Column(name = "sued_yn")
    @Enumerated(EnumType.STRING)
    private SuedYn suedYn;

    //private List<Product> products = new ArrayList<>();

    public UserInfo toUserInfo(){
        return UserInfo.builder()
                .name(name)
                .email(email)
                .address(address)
                .nickname(nickname)
                .temperature(temperature)
                .suedYn(suedYn)
                .build();
    }
}
