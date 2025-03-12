package com.basic.myspringboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("VM Arguments foo : " + args.containsOption("foo"));
        System.out.println("Program Arguments bar : " + args.containsOption("bar"));
    }
}