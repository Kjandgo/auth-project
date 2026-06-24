package com.kjandgo.authproject.member.query.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public interface MemberQueryService {
    List<GrantedAuthority> getUserAuth(Long empId);
}
