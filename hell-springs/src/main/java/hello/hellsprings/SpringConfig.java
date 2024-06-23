package hello.hellsprings;

import hello.hellsprings.repository.JdbcMemberRepository;
import hello.hellsprings.repository.JdbcTemplateMemberRepository;
import hello.hellsprings.repository.MemberRepository;
import hello.hellsprings.repository.MemoryMemberRepository;
import hello.hellsprings.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean // NOTE: memberService를 스프링빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean // NOTE: memberRepository를 스프링빈에 등록
    public MemberRepository memberRepository(){
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
