package hello.hellsprings.controller;

import hello.hellsprings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 의존성 주입, dependency injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
