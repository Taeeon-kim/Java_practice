package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 한번 생성후에 바꾸지않을거기때문에 final 선언
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // NOTE: 구현체에 의존(OCP, DIP 꺠짐), 추상화에 의존하도록
    private final MemberRepository memberRepository; // DIP 준수

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
}
