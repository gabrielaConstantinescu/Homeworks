package org.springtraining.homework1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    MessageRepository messageRepository;

    public void process(Message message){
        messageRepository.store(message);
//        System.out.println("The message having messageId " +  message.getMessageId().getId() + " was processed");
    }
}
