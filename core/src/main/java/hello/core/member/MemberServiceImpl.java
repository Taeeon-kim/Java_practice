package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 한번 생성후에 바꾸지않을거기때문에 final 선언
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // NOTE: 구현체에 의존(OCP, DIP 꺠짐), 추상화에 의존하도록
    private final MemberRepository memberRepository; // DIP 준수

    @Autowired // 마치 ac.getBean(MemberRepository.class) 처럼 동작한다고 생각하면 됨
    public MemberServiceImpl(MemberRepository memberRepository) { // NOTE: 위의 DIP를 지키기위해 생성자를 만들어 생성자를 통해서 구현체를 주입해준다.
        this.memberRepository = memberRepository;
    }

    // 회원가입, 회원을 찾을려면 레퍼지토리가 필요,

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
