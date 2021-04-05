package com.unlu.sdypp.renderizado.fachada.services;

import com.unlu.sdypp.renderizado.fachada.models.FileEntity;
import com.unlu.sdypp.renderizado.fachada.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository repository;

    @Autowired
    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public List<FileEntity> findByFileName(String fileName) {
        return repository.getFilesByName(fileName);
    }

    public FileEntity save(FileEntity entity) {
        return repository.saveFile(entity);
    }

    public void delete (FileEntity entity) {
        repository.deleteFile(entity);
    }
}
