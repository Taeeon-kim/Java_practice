package hello.jdbc.service;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;


/**
 * 트랜잭션 - @Transactional AOP
*/

@Slf4j
public class MemberServiceV3_3 {

//    private final PlatformTransactionManager transactionManager;
    private final MemberRepositoryV3 memberRepository;

    public MemberServiceV3_3( MemberRepositoryV3 memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional // Transaction 시작, 트랜잭션 AOP 적용, 프록시(for 트랜잭션 탬플릿, 트랜잭션 매니저등) 역할해줌
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
                bizLogic(fromId, toId, money);
    }

    private void bizLogic(String fromId, String toId, int money) throws SQLException {
        // 비즈니스로직
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

}
