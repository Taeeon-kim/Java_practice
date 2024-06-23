package hello.hellsprings.repository;

import hello.hellsprings.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) { // 인터페이스로 만들어진 추상 메서드들을 오버라이딩으로 기능 추가해준다.
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream().filter(member-> member.getName().equals(name)).findAny();
    }


    public List<Member> findAll() {
       return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
