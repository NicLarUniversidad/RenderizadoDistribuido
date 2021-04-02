package com.unlu.sdypp.renderizado.fachada.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqRepositoryTest {

    @Autowired
    private RabbitMqRepository repository;

    @Test
    public void publishTest() throws IOException {
        repository.publish("{}", "cola_de_prueba");
    }
}
