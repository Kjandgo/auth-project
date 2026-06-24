package com.kjandgo.authproject.member.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="oauth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Oauth {
    @Id
    @Column
    private long id;
    @Column
    private long memberId;
    @Column
    private String provider;
    @Column
    private String providerUserId;
}
