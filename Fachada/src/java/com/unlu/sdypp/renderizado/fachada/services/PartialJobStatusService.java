package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.PartialJobStatusEntity;
import com.unlu.sdypp.renderizado.fachada.repositories.PartialJobStatusRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartialJobStatusService {

    private final PartialJobStatusRepository repository;

    @Autowired
    public PartialJobStatusService(PartialJobStatusRepository repository) {
        this.repository = repository;
    }

    public List<PartialJobStatusEntity> findByReference(String reference) {
        return repository.getFilesByReference(reference);
    }

    public PartialJobStatusEntity save(PartialJobStatusEntity entity) {
        return repository.save(entity);
    }

    public void delete (PartialJobStatusEntity entity) {
        repository.delete(entity);
    }
}
