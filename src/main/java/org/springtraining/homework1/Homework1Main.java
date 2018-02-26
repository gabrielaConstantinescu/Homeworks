package org.springtraining.homework1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Homework1Main {

    public static void main(String[] args) {

        String[] strArgs = args[0].split("=");
        int param = Integer.valueOf(strArgs[1]);
        System.out.println("Your first argument is:  "+ param);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Homework1Configuration.class);
        BusinessService businessService = applicationContext.getBean(BusinessService.class);
        for (int i=0; i< param; i++){
            businessService.process(applicationContext.getBean(Message.class));
        }



    }

}
