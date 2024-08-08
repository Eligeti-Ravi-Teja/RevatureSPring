package org.example;

import org.example.config.ApplicationConfig;
import org.example.dao.AtmDao;
import org.example.service.AtmService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AtmService atmService=(AtmService) context.getBean("atmService");
        System.out.println("Choose your option: ");
        System.out.println("1. to check balanace || 2. add money  || 3. withdraw money");
        int num=sc.nextInt();
        switch (num) {
            case 1 -> atmService.showBalanace();
            case 2 -> atmService.addMoney(200);
            case 3 -> atmService.withdraw(40);
        }
    }
}