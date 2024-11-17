package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired LogRepository logRepository;

    /*
    * memberService     @Transactional:OFF
    * memberRepository  @Transactional:ON
    * logRepository     @Transactional:ON
    * */
    @Test
    void outerTxOff_success(){
        //give
        String username = "outerTxOff_success";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }


    /*
     * memberService     @Transactional:OFF
     * memberRepository  @Transactional:ON
     * logRepository     @Transactional:ON Exception 발생
     * */
    @Test
    void outerTxOff_fail(){
        //give
        String username = "로그예외_outerTxOff_success";

        //when
        assertThatThrownBy(()->   memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /*
     * memberService     @Transactional:ON
     * memberRepository  @Transactional:OFF
     * logRepository     @Transactional:OFF
     * */
    @Test
    void singleTx(){
        //give
        String username = "singleTx";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /*
     * memberService     @Transactional:ON
     * memberRepository  @Transactional:ON
     * logRepository     @Transactional:ON
     * */
    @Test
    void outerTxOn_success(){
        //give
        String username = "outerTxOn_success";

        //when
        memberService.joinV1(username);

        //then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /*
     * memberService     @Transactional:ON
     * memberRepository  @Transactional:ON
     * logRepository     @Transactional:ON Exception 발생
     * */
    @Test
    void outerTxOn_fail(){
        //give
        String username = "로그예외_outerTxOn_fail";

        //when
        assertThatThrownBy(()-> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        //then: 모든데이터 롤백됨
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /*
     * memberService     @Transactional:ON
     * memberRepository  @Transactional:ON
     * logRepository     @Transactional:ON Exception 발생
     * */
    @Test
    void recoverException_fail(){
        //give
        String username = "로그예외_recoverException_fail";

        //when
        assertThatThrownBy(()-> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        //then: 모든데이터 롤백됨
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /*
     * memberService     @Transactional:ON
     * memberRepository  @Transactional:ON
     * logRepository     @Transactional:ON(REQUIRES_NEW) Exception 발생
     * */
    @Test
    void recoverException_success(){
        //give
        String username = "로그예외_recoverException_success";

        //when
         memberService.joinV2(username);

        //then: member저장, log 롤백됨
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }


}