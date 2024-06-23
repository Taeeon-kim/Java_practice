package hello.hellsprings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    @GetMapping("hello") // NOTE: 해당 path 경로 이름으로 매핑해줌
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // NOTE: 해당 이름의 html 이름으로 렌더링 시켜줌
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // NOTE: @Requestparam사용 name이라는 파라미터를 받아서 사용
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  // NOTE: HttpMessageconverter, MappingJackson2HttpMessageConverter사용하여 json으로 변환해줘서 바디에 준다
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
