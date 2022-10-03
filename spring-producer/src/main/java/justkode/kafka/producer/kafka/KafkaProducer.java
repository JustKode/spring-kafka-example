package justkode.kafka.producer.kafka;

import lombok.RequiredArgsConstructor;
import message.UserMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "userMessage";
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public void sendMessage(UserMessage message) throws IOException {
        System.out.println("produce message = " + message);
        this.kafkaTemplate.send(TOPIC, message.packObject());
    }
}
