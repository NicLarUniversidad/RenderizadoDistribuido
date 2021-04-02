package com.unlu.sdypp.renderizado.fachada.repositories;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Repository
public class RabbitMqConsumer<T> {
    private static Logger logger = LoggerFactory.getLogger(RabbitMqRepository.class);

    @Value("${facade.queue.uri}")
    private String uri;

    private Connection connection;

    private Channel channel;

    @PostConstruct
    public void postConstruct() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(uri);
        factory.setConnectionTimeout(20000);
        try  {
            this.connection = factory.newConnection();
            this.channel = connection.createChannel();
        } catch (TimeoutException | IOException e) {
            logger.error("No se pudo conectar con rabbit", e);
        }
    }

    private List<String> messages = new ArrayList<>();

    public void listen(String queue) throws IOException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            messages.add(message);
            logger.info(message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };
        channel.basicConsume(queue, false, deliverCallback, consumerTag -> { });
    }

    public List<String> getMessages() {
        return messages;
    }
}
