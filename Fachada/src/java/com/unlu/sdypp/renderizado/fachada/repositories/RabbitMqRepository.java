package com.unlu.sdypp.renderizado.fachada.repositories;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Repository
public class RabbitMqRepository {

    private static Logger logger = LoggerFactory.getLogger(RabbitMqRepository.class);

    @Value("facade.queue.ip")
    private String ip;

    @Value("facade.queue.port")
    private int port;

    private Connection connection;

    private Channel channel;

    @Autowired
    public RabbitMqRepository() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ip);
        factory.setPort(port);
        try  {
            connection = factory.newConnection();
            channel = connection.createChannel();
        } catch (TimeoutException | IOException e) {
            logger.error("No se pudo conectar con rabbit", e);
        }
    }

    public void publish(String json, String queue) throws IOException {
        logger.info("Mandando json: '" + json + "' a cola '" + queue + "'...");
        channel.queueDeclare(queue, false, false, false, null);
        channel.basicPublish("", queue, null, json.getBytes());
        logger.info("Json encolado correctamente");
    }
}
