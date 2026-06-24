package com.kjandgo.authproject.member.command.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailInfoDTO {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String signUpDate;
    private String recentLoginDate;
    private Character status;
    private String profileImage;
}
