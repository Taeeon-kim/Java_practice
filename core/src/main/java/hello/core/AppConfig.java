package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){ // 맴버서비스
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }

    public OrderService orderService(){ // 오더 서비스
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); // 생성자 호출, 참조값을 생성자에 주입해줌
    }


}
