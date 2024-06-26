package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 한번 생성후에 바꾸지않을거기때문에 final 선언
    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
