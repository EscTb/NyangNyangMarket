package com.esctb.restapiserver.domain.user.dto;

import com.esctb.restapiserver.domain.user.entity.Address;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.entity.enums.SuedYn;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UserDto {
    private String name;
    private String password;
    private String email;
    private Address address;
    private String nickname;
    private int temperature;
    private SuedYn suedYn;

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
