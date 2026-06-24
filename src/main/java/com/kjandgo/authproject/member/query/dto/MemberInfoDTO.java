package com.kjandgo.authproject.member.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberInfoDTO {
    private String id;
    private String userName;
    private String name;
    private String email;
    private String profileImage;
}
