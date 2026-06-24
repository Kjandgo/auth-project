package com.kjandgo.authproject.member.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="login_history")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String loginTrialDate;
    @Column
    private String loginIsSucceed;
    @Column
    private String loginIp;
    @Column
    private String description;
    @Column
    private Long memberId;
}