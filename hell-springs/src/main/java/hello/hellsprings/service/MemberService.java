package hello.hellsprings.service;

import hello.hellsprings.domain.Member;
import hello.hellsprings.repository.MemberRepository;
import hello.hellsprings.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private final MemberRepository memberRepository ;

    public Long join(Member member){
        // 같은 이름이 있는 중복회원X
        validateDuplicateMember(member); // NOTE: 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
             .ifPresent(m-> {
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
             });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
