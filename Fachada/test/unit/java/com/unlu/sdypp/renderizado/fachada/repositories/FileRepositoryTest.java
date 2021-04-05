package com.unlu.sdypp.renderizado.fachada.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRepositoryTest {

    @Autowired
    private FileRepository repository;

    @Test
    public void getFileByNameTest() throws URISyntaxException {
        repository.getFilesByName("");
    }
}
