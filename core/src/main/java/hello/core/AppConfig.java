package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 구성 영역(공연 기획, 담당 섭외등)

    @Bean
    public MemberService memberService(){ // 맴버서비스 역할
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }

    @Bean
    public OrderService orderService(){ // 오더 서비스 역할
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository(); // 구현체
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); // 구현체
    }

}
