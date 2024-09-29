package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler; // Object를 ControllerV4로 캐스팅
        Map<String, String> paramMap = createParamMap(request); // request parameter데이터를 map에 저장
        HashMap<String, Object> model = new HashMap<>(); // 해시맵 모델 데이터 구조 생성
        String ViewName = controller.process(paramMap, model); // 해당 컨트롤러 ControllerV4구현체에 해당 파라미터데이터 및 모델 해시맵 객체를 넣어주고 viewName반환 받음

        ModelView modelView = new ModelView(ViewName); // view관련 모델 생성후 해당 Name 추가
        modelView.setModel(model); // viewModel에서 사용할 해시맵 데이터 model을 삽입
        return modelView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
