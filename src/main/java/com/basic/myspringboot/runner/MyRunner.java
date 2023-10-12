package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(1) //1번으로 실행될 러너 컴포넌트로 지정
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}") //@Value = 프로퍼티에서 변수 값 가져옴
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Value("${myboot.fullName}")
    private String fullName;

    @Autowired
    private Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("portNum= "+environment.getProperty("local.server.port"));
        System.out.println("mybootname"+name);
        System.out.println("mybootage"+age);
        System.out.println("mybootfullname"+fullName);
        System.out.println("vm Argument foo: " + args.containsOption("foo"));
        System.out.println("vProgram Argument bar: " + args.containsOption("bar"));
        System.out.println("git test!!");


    }
}
