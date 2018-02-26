package org.springtraining.homework1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Homework1Configuration {

       @Bean
       public MessageRepository messageRepository(ApplicationProperties repositoryType){
           MessageRepository repository = null;
           if ("IN_MEMORY".equals(repositoryType.getType())){
               repository = new InMemoryStoreRepository();
           }else if ("FILE_STORE".equals(repositoryType.getType())){
               repository = new FileStoreRepository();
           }else{
               System.out.println("Type of repository unknown");
           }
            return repository;
       }


}
