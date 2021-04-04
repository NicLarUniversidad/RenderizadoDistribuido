package com.unlu.sdypp.renderizado.fileserver.services;

import com.unlu.sdypp.renderizado.fileserver.IntegrationTest;
import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import com.unlu.sdypp.renderizado.fileserver.entities.JobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.JobStatusRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JobStatusServiceTest extends IntegrationTest {

    @Autowired
    private JobStatusRepository repository;

    private JobStatusEntity entity;

    @Before
    public void before() {
        entity = new JobStatusEntity();
        entity.setOriginalFileReference("test.txt");
        entity.setRenderedFileReference("rendered.txt");
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
        var list = repository.findByOriginalFileReference(entity.getOriginalFileReference());
        assertThat(list.size()).isEqualTo(1);
    }
}
