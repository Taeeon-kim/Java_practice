package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;

import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV3 extends HttpServlet {

    HashMap<String , ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        System.out.println("FrontControllerServletV3.FrontControllerServletV3");
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI();
        System.out.println("requestURI2 = " + requestURI);
        ControllerV3 controller = controllerMap.get(requestURI);
        System.out.println("controller = " + controller);
        if (controller==null){
            System.out.println("controller is null?? = " + controller);
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // paramMap
        HashMap<String, String> paramMap = createParamMap(request);
        ModelView modelView = controller.process(paramMap);
        System.out.println("here!!"+ modelView);
        System.out.println("here!!2"+ modelView.getModel());
        String viewName = modelView.getViewName(); // 논리 이름 ex) new-form
        System.out.println("viewName = " + viewName);
        MyView view = viewResolver(viewName);
        System.out.println("view = " + view);
        view.render(modelView.getModel(), request, response);

    }

    private MyView viewResolver(String viewName) {
        System.out.println("viewName = " + viewName);
        return new MyView("WEB-INF/views/" + viewName + ".jsp");
    }

    private HashMap<String, String> createParamMap(HttpServletRequest request) {
        HashMap<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().
                forEachRemaining(paramName-> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
