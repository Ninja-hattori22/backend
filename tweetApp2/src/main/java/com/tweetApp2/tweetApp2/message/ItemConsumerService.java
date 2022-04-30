package com.tweetApp2.tweetApp2.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.tweetApp2.tweetApp2.kafkaConfig.*;

@Service
public class ItemConsumerService {
	@Autowired
	kafkaConfiguration kafkaConfiguration;
	
	
	@KafkaListener(topics = "tweet", groupId = "tweet-group",containerFactory = "kafkaListenerContainerFactory")
    public void consume(String item){
        System.out.println("Consumed Message :"+item);
    }
}
