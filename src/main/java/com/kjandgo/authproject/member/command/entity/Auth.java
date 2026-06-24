package com.kjandgo.authproject.member.command.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="auth")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Auth {
    @Id
    @Column
    private long id;
    @Column
    private String authName;
    @Column
    private String description;
}
