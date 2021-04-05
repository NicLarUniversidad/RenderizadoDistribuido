package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.JobStatusEntity;
import com.unlu.sdypp.renderizado.fachada.repositories.JobStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobStatusService {

    private final JobStatusRepository repository;

    @Autowired
    public JobStatusService(JobStatusRepository repository) {
        this.repository = repository;
    }

    public List<JobStatusEntity> findByReference(String reference) {
        return repository.getFilesByReference(reference);
    }

    public JobStatusEntity save(JobStatusEntity entity) {
        return repository.save(entity);
    }

    public void delete (JobStatusEntity entity) {
        repository.delete(entity);
    }
}
