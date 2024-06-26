package hello.hellsprings;

import hello.hellsprings.aop.TimeTraceAop;
import hello.hellsprings.repository.*;
import hello.hellsprings.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;


//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }


    private EntityManager em;

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean // NOTE: memberService를 스프링빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean // NOTE: memberRepository를 스프링빈에 등록
    public MemberRepository memberRepository(){
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
//
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }
}
