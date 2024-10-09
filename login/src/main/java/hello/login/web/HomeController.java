package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

   private final MemberRepository memberRepository;

//    @GetMapping("/")
    public String home() {
        System.out.println("here");
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(@CookieValue(name="memberId", required = false) Long memberId, Model model){
        if(memberId == null){
            return "home";
        }
        System.out.println("there");
        System.out.println("memberId = " + memberId);
        System.out.println("memberRepository.findAll() = " + memberRepository.findAll());
        //로그인
        Member loginMember = memberRepository.findById(memberId);

        System.out.println("loginMember = " + loginMember);
        if(loginMember == null){
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";

    }
}