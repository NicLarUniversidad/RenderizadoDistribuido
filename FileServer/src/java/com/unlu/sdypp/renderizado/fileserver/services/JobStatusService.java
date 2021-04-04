package com.unlu.sdypp.renderizado.fileserver.services;

import com.unlu.sdypp.renderizado.fileserver.entities.JobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.JobStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobStatusService {

    private JobStatusRepository repository;

    @Autowired
    public JobStatusService(JobStatusRepository repository) {
        this.repository = repository;
    }

    public JobStatusEntity save(JobStatusEntity entity) {
        return repository.save(entity);
    }

    public void delete(JobStatusEntity entity) {
        repository.delete(entity);
    }

    public JobStatusEntity find(String id) {
        var optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    public List<JobStatusEntity> findByReference(String refId) {
        return repository.findByOriginalFileReference(refId);
    }
}
