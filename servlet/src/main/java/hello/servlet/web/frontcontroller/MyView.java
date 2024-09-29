package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("viewPath = " + viewPath);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        modelToRequestAttribute(model, request); // 해시맵 model에 담았던 데이터를 request attribute에 저장
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // dispatcher에 path저장
        dispatcher.forward(request, response); // forward를 통해 전달
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value)-> request.setAttribute(key, value));
    }
}
