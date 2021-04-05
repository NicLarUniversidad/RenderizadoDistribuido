package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.PartialJobEntity;
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

    public List<PartialJobEntity> findByReference(String reference) {
        return repository.getFilesByReference(reference);
    }

    public PartialJobEntity save(PartialJobEntity entity) {
        return repository.save(entity);
    }

    public void delete (PartialJobEntity entity) {
        repository.delete(entity);
    }
}
