package hello.jdbc.repository;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

/**
* JDBC - DataSource 사용, JdbcUtils 사용
*/

@Slf4j
public class MemberRepositoryV1 {

    private final DataSource dataSource;

    public MemberRepositoryV1(DataSource dataSource) {
        this.dataSource = dataSource; // DI, 의존관계 주입
    }

    public Member save(Member member) throws SQLException {
        String sql = "insert into member(member_id, money) values(?, ?)";
        Connection con = null;

        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            System.out.println("save");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getMemberId());
            pstmt.setInt(2, member.getMoney());
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null); // con, pstmt에서도 에러가 발생할수있어서 이렇게 처리
        }

    }

    public Member findById(String memberId) throws SQLException {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = getConnection();
            System.out.println("findById");
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();
            if(rs.next()){
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            } else{
                throw new NoSuchElementException("member not found memberId = "+memberId);
            }

        }catch (SQLException e){
            log.error("error",e);
            throw e;
        } finally{
            close(con, pstmt, rs);
        }
    }

    public void update(String memberId, int money) throws SQLException {
        String sql = "update member set money =? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            System.out.println("update");
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,money);
            pstmt.setString(2, memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize={}", resultSize);

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null); // con, pstmt에서도 에러가 발생할수있어서 이렇게 처리
        }
    }

    public void delete(String memberId) throws SQLException {
        String sql = "delete from member where member_id=?";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            System.out.println("delete");
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, memberId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        } finally {
            close(con, pstmt, null); // con, pstmt에서도 에러가 발생할수있어서 이렇게 처리
        }

    }

    private void close(Connection con, Statement stmt, ResultSet rs){

        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);
        // 아래 코드는 이미 JdbcUtils에 로직들어가있기때문에 위에 close- 메서드사용

//        if(stmt != null){
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                log.error("error", e);
//            }
//        }
//        if(con != null){
//            try {
//                con.close();  // tcp/ip 를 끊어줘야함, 이 코트드 무조건 실행되도록 보장해줘야함 필수!
//            } catch (SQLException e) {
//                log.error("error", e);
//            }
//        }
    }

    private Connection getConnection() throws SQLException {
        Connection con = dataSource.getConnection();
        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }
}
