package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo") // NOTE: 핸들러 매핑, 핸들러 : 요청에 대해 비즈니스로직 수행 및 결과 생성하여 반환
    @ResponseBody // NOTE: view 없기에 문자열 그대로 반환
    public String logDemo(HttpServletRequest request) throws InterruptedException{
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testID");
        return "<string>OK</string>";
    }
}
