package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    // control + enter generate 단축키 (생성자)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

