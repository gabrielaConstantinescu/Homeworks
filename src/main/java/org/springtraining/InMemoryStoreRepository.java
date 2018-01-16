package org.springtraining;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryStoreRepository implements MessageRepository {


    public void store(Message message) {

        System.out.println("InMemoryStoreRepository I have received message with messageId " +  message.getMessageId().getId());

    }


}
