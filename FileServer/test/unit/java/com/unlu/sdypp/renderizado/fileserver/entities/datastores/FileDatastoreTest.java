package com.unlu.sdypp.renderizado.fileserver.entities.datastores;

import com.unlu.sdypp.renderizado.fileserver.IntegrationTest;
import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.FileRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class FileDatastoreTest /*extends IntegrationTest*/ {

    @Autowired
    private FileRepository repository;

    private FileEntity entity;

    @Before
    public void before() {
        entity = new FileEntity();
        entity.setFileName("test.txt");
        entity.setContent("test");
        entity.setFrames(1);
    }

    @After
    public void after() {
        repository.delete(entity);
    }

    @Test
    public void saveTest() {
        repository.save(entity);
        assertThat(entity.getId()).isNotEmpty();
    }

    @Test
    public void findTest() {
        repository.save(entity);
        var list = repository.findById(entity.getId());
        assertThat(list.isPresent()).isTrue();
        assertThat(list.get()).isNotNull();
    }

    @Test
    public void deleteTest() {
        repository.save(entity);
        var list = repository.findById(entity.getId());
        assertThat(list.isPresent()).isTrue();
        assertThat(list.get()).isNotNull();
        repository.delete(entity);
        list = repository.findById(entity.getId());
        assertThat(list.isPresent()).isFalse();
    }

    @Test
    public void findByNameTest() {
        repository.save(entity);
        var list = repository.findByFileName(entity.getFileName());
        assertThat(list.size()).isEqualTo(1);
    }
}
