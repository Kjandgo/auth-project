package com.kjandgo.authproject.member.command.repository;

import com.kjandgo.authproject.member.command.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginHistoryCommandRepository extends JpaRepository<LoginHistory,Long> {
}

