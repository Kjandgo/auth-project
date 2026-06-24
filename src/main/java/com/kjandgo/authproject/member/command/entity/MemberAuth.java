package com.kjandgo.authproject.member.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="member_auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberAuth {
    @Id
    @Column
    private long id;
    @Column
    private long authId;
    @Column
    private long memberId;
}
