package com.basic.myspringboot.runner;

import com.basic.myspringboot.config.CustomVO;
import com.basic.myspringboot.property.MybootProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    String name;

    @Value("${myboot.age}")
    int age;

    @Autowired
    Environment env;

    @Autowired
    MybootProperties properties;

    @Autowired
    CustomVO customVO;

    public void run(ApplicationArguments args) throws Exception {
        System.out.println("현재 활성화된 CustomerVO " + customVO);
        System.out.println("@Value myboot.name " + name);
        System.out.println("@Value myboot.age " + age);
        System.out.println("Environment myboot.fullName " +
                env.getProperty("myboot.fullName"));
        System.out.println("Environment server.port " +
                env.getProperty("local.server.port"));
        System.out.println("MybootProperties getFullName " +
                properties.getFullName());

        System.out.println("VM Arguments foo : " + args.containsOption("foo"));
        System.out.println("Program Arguments bar : " + args.containsOption("bar"));

        //환경변수 이름을 출력하기
        args.getOptionNames() //Set<String>
                //forEach(Consumer) Consumer 의 추상메서드 void accept(T)
                .forEach(name -> System.out.println(name));
    }
}