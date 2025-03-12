package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    String name;

    @Value("${myboot.age}")
    int age;

    public void run(ApplicationArguments args) throws Exception {
        System.out.println("myboot.name " + name);
        System.out.println("myboot.age " + age);
        System.out.println("VM Arguments foo : " + args.containsOption("foo"));
        System.out.println("Program Arguments bar : " + args.containsOption("bar"));

        //환경변수 이름을 출력하기
        args.getOptionNames() //Set<String>
                //forEach(Consumer) Consumer 의 추상메서드 void accept(T)
                .forEach(name -> System.out.println(name));
    }
}