package com.unlu.sdypp.renderizado.fileserver.services;

import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import com.unlu.sdypp.renderizado.fileserver.repositories.FileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private FileRepository repository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.repository = fileRepository;
    }

    public FileEntity save(FileEntity fileEntity) {
        return repository.save(fileEntity);
    }

    public void delete (FileEntity fileEntity) {
        repository.delete(fileEntity);
    }

    public FileEntity find(String id) {
        var optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

    public List<FileEntity> findByFileName(String fileName) {
        return repository.findByFileName(fileName);
    }
}
