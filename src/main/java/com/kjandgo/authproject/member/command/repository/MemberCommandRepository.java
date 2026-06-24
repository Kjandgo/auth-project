package com.kjandgo.authproject.member.command.repository;

import com.kjandgo.authproject.member.command.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberCommandRepository extends JpaRepository<Member,Long> {
    Member findByUserName(String userName);
}
