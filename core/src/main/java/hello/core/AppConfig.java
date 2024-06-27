package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ // 맴버서비스 역할
        return new MemberServiceImpl(memberRepository()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }
    public OrderService orderService(){ // 오더 서비스 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 구현체
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy(); // 구현체
    }

}
