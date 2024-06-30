package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements  MemberRepository{ // 메모리방식의 레퍼지토리

    private static Map<Long, Member> store = new HashMap<>(); // 메모리 사용을위해 해시맵 구현


    @Override
    public void save(Member member) { // 해시맵 매서드의 put 사용하여 생성한 store 에 저장
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) { // 가입된 맴버를 찾을때 사용하는 메서드로, 해시맵의 get을 이용하여 특정 Id값으로 해시맵을 찾는다.
        return store.get(memberId);
    }
}
