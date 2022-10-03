package justkode.kafka.consumer.kafka;

import message.UserMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "userMessage", groupId = "test")
    public void consume(byte[] message) throws IOException {
        System.out.println("Consumed Message = " + UserMessage.unpackObject(message));
    }
}
