package mngrailsdemo;


import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RabbitListener
public class MessageListener {
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @Queue("demomessages")
    public void receiveMessage(String message) {
        log.info("Received message {}", message);
    }

}
