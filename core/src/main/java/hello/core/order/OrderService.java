package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice); // 상품 오더시 주문자Id, 아이템이름, 아이템가격 을 받아서 주문 생성
}
