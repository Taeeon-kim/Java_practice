package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet",urlPatterns = "/servlet-mvc/members") // controller 역할
public class MvcMemberListServlet extends HttpServlet {

   MemberRepository memberRepository  = MemberRepository.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // repository 호출
        List<Member> members = memberRepository.findAll();

        // Model에 데이터 저장
        request.setAttribute("members", members);

        // view로 전달 이때 view는 viewPath 에담긴 jsp, 그럼 view가 화면에 보임
        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
