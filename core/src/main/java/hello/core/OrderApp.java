package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) { // 앱 실행 main생성

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // 회원가입/ 조회 맴버서비스 구현체 채택 생성
        OrderService orderService  = appConfig.orderService(); // 할인가, 회원에 따른 주문생성 구현체 채택 생성

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // mamberA라는 VIP 고객 생성
        memberService.join(member); // 회원가입

       Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order= " + order); // 주문 디테일
        System.out.println("calculatePrice = " + order.calculatePrice()); // 할인 적용가





    }
}
