package com.hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-required")
    public String requestRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age // null 값을 받기위해선 Integer 객체사용
    ){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age
    ){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

     @ResponseBody // http 응답 메세지 바디에 바로 전달하도록 사용(클래스레벨에 RestController로 교체해도됨)
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
