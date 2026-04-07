package com.kjandgo.authproject.member.command.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {
    private String memberId;
    private String pwd;
}
