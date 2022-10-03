package justkode.kafka.producer.kafka;

import lombok.RequiredArgsConstructor;
import message.UserMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "")
public class KafkaController {
    private final KafkaProducer producer;

    @PostMapping("/message")
    public String sendMessage(@RequestBody UserMessage message) throws IOException {
        producer.sendMessage(message);
        return "success";
    }
}
