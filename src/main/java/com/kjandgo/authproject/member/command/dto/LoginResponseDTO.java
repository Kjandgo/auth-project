package com.kjandgo.authproject.member.command.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO {
    private String id;
    private String nickName;
    private String accessToken;
    private String refreshToken;
    private List<String> roles;

}
