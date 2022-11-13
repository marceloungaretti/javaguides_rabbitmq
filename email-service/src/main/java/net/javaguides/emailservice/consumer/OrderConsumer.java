package net.javaguides.emailservice.consumer;

import net.javaguides.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent event){
        //caso de erro para rodar a aplicacao de email pq a fila nao existe, mandar uma mensagem para ela, que entao o outro serviço vai criar
        LOGGER.info(String.format("Order event received in email service => %s", event.toString()));
    }
}
