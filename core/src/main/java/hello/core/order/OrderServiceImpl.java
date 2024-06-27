package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{ // 주문 서비스 구현체

    private final MemberRepository memberRepository = new MemoryMemberRepository(); // 회원찾기를 위한 맴버레퍼지토리, 메모리레퍼지토리로 채택하여 인스턴스 생성

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 할인을 위한 할인정책, 정액할인 정책으로 채택하여 인스턴스 생성
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 할인을 위한 할인정책, 정률할인 정책으로 채택하여 인스턴스 생성

    private DiscountPolicy discountPolicy; // DIP 를 지키기위해 인터페이스만 의존하도록 만들었지만, 실제 구체화된것이 없기때문에 외부에서 이를 구현하여 넣을수있게 해줘야함
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) { // 주문생성 선언부, 해당 맴버 아이디, 아이템 이름, 아이템 가격
        Member member = memberRepository.findById(memberId); // 해당 맴버 아이디로 맴버 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 해당 맴버와 아이템을 넘겨 얼마의 할인을 받을수있는지 할인정책에 넘김
        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 주문생성을 위한 주문 생성후 리턴
    }
}
