package com.kjandgo.authproject.member.query.service;

import com.kjandgo.authproject.member.query.mapper.MemberQueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberQueryMapper memberQueryMapper;
    public MemberQueryServiceImpl(MemberQueryMapper memberQueryMapper) {
        this.memberQueryMapper = memberQueryMapper;
    }

    @Override
    public List<GrantedAuthority> getUserAuth(Long memberId) {
        return memberQueryMapper.getUserAuth(memberId).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
