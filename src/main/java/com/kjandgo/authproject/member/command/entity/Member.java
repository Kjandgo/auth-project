package com.kjandgo.authproject.member.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String signUpDate;
    @Column
    private String recentLoginDate;
    @Column
    private String status;
    @Column
    private String profileImage;

}
