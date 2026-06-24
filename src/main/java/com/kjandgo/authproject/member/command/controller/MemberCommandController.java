package com.kjandgo.authproject.member.command.controller;

import com.kjandgo.authproject.member.command.service.MemberCommandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberCommandController {
    private final MemberCommandService memberCommandService;

    public MemberCommandController(MemberCommandService memberCommandService) {
        this.memberCommandService = memberCommandService;
    }
}
