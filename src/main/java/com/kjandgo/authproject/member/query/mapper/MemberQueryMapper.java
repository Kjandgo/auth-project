package com.kjandgo.authproject.member.query.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberQueryMapper {
    List<String> getUserAuth(Long memberId);
}
