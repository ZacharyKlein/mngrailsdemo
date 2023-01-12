package mngrailsdemo;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient
public interface MessageSender {

    @Binding("demomessages")
    void send(String message);
}
