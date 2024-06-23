package hello.hellsprings.repository;

import hello.hellsprings.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // NOTE: Optional 은 자바8에 추가된걸로 findById로 null 값도 리턴할수있기때문에 이를위해
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
