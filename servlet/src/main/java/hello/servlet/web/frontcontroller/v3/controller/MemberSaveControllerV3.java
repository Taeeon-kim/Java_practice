package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        /*
        *  request.getParameter("username");
        *  Integer.parseInt(request.getParameter("age"));
        *  와 같이 request, response 등 Servlet http에 종속된 부분을 매개편수 처리하여 DI 주입되도록 처리
         */

        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member); // member 데이터를 Model로 등록
        return modelView;
    }
}
