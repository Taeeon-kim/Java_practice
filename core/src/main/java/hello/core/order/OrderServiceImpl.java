package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{ // 주문 서비스 구현체


    private MemberRepository memberRepository; // DIP를 지키귀위해 인터페이스만 의존하도록 만듬
    private DiscountPolicy discountPolicy; // DIP 를 지키기위해 인터페이스만 의존하도록 만들었지만, 실제 구체화된것이 없기때문에 외부에서 이를 구현하여 넣을수있게 해줘야함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) { // 생성자를 통해 인터페이스의 구현체를 주입
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { // 주문생성 선언부, 해당 맴버 아이디, 아이템 이름, 아이템 가격
        Member member = memberRepository.findById(memberId); // 해당 맴버 아이디로 맴버 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 해당 맴버와 아이템을 넘겨 얼마의 할인을 받을수있는지 할인정책에 넘김
        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 주문생성을 위한 주문 생성후 리턴
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
