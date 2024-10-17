package com.hello.springmvc.basic.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestAutowired {

    @Autowired
    ApplicationContext ac;

    public void getAc(){
        System.out.println("ac = " + ac);
        System.out.println("ac.getClass = " + ac.getClass());
    }
}
