package com.esctb.restapiserver.domain.user.dto;

import com.esctb.restapiserver.domain.user.entity.Address;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.entity.enums.SuedYn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class joinUserRequestDto {

    private String name;
    private String email;
    private Address address;
    private String nickname;
    private int temperature;
    private SuedYn suedYn;

/*    @Builder
    public joinUserRequestDto(String name, String email, Address address, String nickname, int temperature, SuedYn suedYn){
        this.name = name;
        this.email = email;
        this.address = address;
        this.nickname = nickname;
        this.temperature = temperature;
        this.suedYn = suedYn;
    }*/

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .address(address)
                .nickname(nickname)
                .temperature(temperature)
                .suedYn(suedYn)
                .build();
    }
}
