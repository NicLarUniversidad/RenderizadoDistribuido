package com.unlu.sdypp.renderizado.fileserver.services;

import com.unlu.sdypp.renderizado.fileserver.IntegrationTest;
import com.unlu.sdypp.renderizado.fileserver.entities.PartialJobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.PartialJobStatusRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PartialJobStatusServiceTest extends IntegrationTest {

    @Autowired
    private PartialJobStatusRepository repository;

    private PartialJobStatusEntity entity;

    @Before
    public void before() {
        entity = new PartialJobStatusEntity();
        entity.setJobReference("123456");
        entity.setInitialPart(1);
        entity.setFinalParts(1);
        entity.setCompletes(1);
        entity.setStartDate(new Date());
        entity.setFinishDate(new Date());
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
        var list = repository.findByJobReference(entity.getJobReference());
        assertThat(list.size()).isEqualTo(1);
    }
}
