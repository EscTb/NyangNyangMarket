package com.esctb.restapiserver.domain.user.dto;

import com.esctb.restapiserver.domain.user.entity.Address;
import com.esctb.restapiserver.domain.user.entity.User;
import com.esctb.restapiserver.domain.user.entity.enums.SuedYn;
import lombok.*;

import java.time.LocalDateTime;

public class UserDto {


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo{
        private Long id;
        private String name;
        private String password;
        private String email;
        private Address address;
        private String nickname;
        private Double temperature;
        private SuedYn suedYn;

        /*public static UserInfoBuilder userDtoBuilder(Long id){
            if(id==null){
                throw new IllegalArgumentException("필수 파라미터 누락");
            }
            return builder().id(id);
        }*/

        public User toEntity(){
            return User.builder()
                    .name(name)
                    .email(email)
                    .address(address)
                    .nickname(nickname)
                    .temperature(temperature)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserJoinRequestDto {

        private String name;
        private String password;
        private String email;
        private Address address;
        private String nickname;
        private int temperature;

        public User toEntity(){
            return User.builder()
                    .name(name)
                    .password(password)
                    .email(email)
                    .address(address)
                    .nickname(nickname)
                    .build();
        }
    }


    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserLoginDto{
        private String email;
        private String password;
    }
}
