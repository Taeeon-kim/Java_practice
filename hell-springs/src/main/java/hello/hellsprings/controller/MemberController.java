package hello.hellsprings.controller;

import hello.hellsprings.domain.Member;
import hello.hellsprings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired // 의존성 주입, dependency injection
    public MemberController(MemberService memberService) { // NOTE: 주입방법이 3개정도있는데 생성사 주입으로 사용
        this.memberService = memberService;
        System.out.println("memberService = "+ memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = " + member.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
