package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHtmlServlet", urlPatterns="/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //Content-Type: text/html;chatset=utf-9
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter write = response.getWriter();
        write.println("<html>" +
                "<body>" +
                "<div>안녕??</div>" +
                "</body>" +
                "</html>");

    }
}
