package org.springtraining;

import org.springframework.stereotype.Repository;

@Repository
public class FileStoreRepository implements MessageRepository {


    public void store(Message message) {
        System.out.println("FileStoreRepository: I have received message with messageId " +  message.getMessageId().getId());
    }


}
