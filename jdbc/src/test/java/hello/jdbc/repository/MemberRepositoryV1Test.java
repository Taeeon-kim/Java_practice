package hello.jdbc.repository;

import com.zaxxer.hikari.HikariDataSource;
import hello.jdbc.connection.ConnectionConst;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static hello.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
class MemberRepositoryV1Test {

    MemberRepositoryV1 repository;
    Member member = new Member("memberV5", 10000);

    @BeforeEach
    void beforeEach() {

        enum SourceType{
            DRIVERMANAGER,
            CONNECTIONPOOL
        };
        SourceType sourceType = SourceType.CONNECTIONPOOL;
        switch (sourceType){

            case DRIVERMANAGER: {     // 기본 DriverManager - 항상 새로운 커넥션을 획득하는 방식
                DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
                repository = new MemberRepositoryV1(dataSource);
                break;
            }
            case CONNECTIONPOOL: { // 커넥션 풀링 방식
                HikariDataSource dataSource = new HikariDataSource();
                dataSource.setJdbcUrl(URL);
                dataSource.setUsername(USERNAME);
                dataSource.setPassword(PASSWORD);
                repository = new MemberRepositoryV1(dataSource);
                break;
            }
        }
    }

    @AfterEach
    void afterEach() throws SQLException, InterruptedException { // 테스트를 위해 중복되는 등록을 없애기위해 테스트완료후 삭제는 여기서 진행
        //delete
        repository.delete(member.getMemberId());
        assertThatThrownBy(()-> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
        Thread.sleep(1000);
    }

    @Test
    void crud() throws SQLException {


        // save

        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember={}", findMember);
        log.info("member == findMember {}", member == findMember);
        log.info("member equals findMember {}", member.equals(findMember));
        assertThat(findMember).isEqualTo(member);


        //update: money 10000 -> 20000
        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

//        //delete
//        repository.delete(member.getMemberId());
//        assertThatThrownBy(()-> repository.findById(member.getMemberId()))
//                .isInstanceOf(NoSuchElementException.class);
    }
}