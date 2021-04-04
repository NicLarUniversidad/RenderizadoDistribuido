package com.unlu.sdypp.renderizado.fileserver.services;

import com.unlu.sdypp.renderizado.fileserver.entities.PartialJobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.PartialJobStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartialJobStatusService {

    private PartialJobStatusRepository repository;

    @Autowired
    public PartialJobStatusService(PartialJobStatusRepository repository) {
        this.repository = repository;
    }

    synchronized public PartialJobStatusEntity save(PartialJobStatusEntity entity) {
        return repository.save(entity);
    }

    public void delete(PartialJobStatusEntity entity) {
        repository.delete(entity);
    }

    public PartialJobStatusEntity find(String id) {
        var optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    public List<PartialJobStatusEntity> findByJobReference(String jobId) {
        return repository.findByJobReference(jobId);
    }
}
