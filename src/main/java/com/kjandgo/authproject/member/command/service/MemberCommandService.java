package com.kjandgo.authproject.member.command.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface MemberCommandService {
    void saveLoginHistory(Long id, String ipAddress, char y);

    UserDetails loadUserByUsername(String empId);
}
