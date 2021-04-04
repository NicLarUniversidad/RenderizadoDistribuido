package com.unlu.sdypp.renderizado.fileserver.controllers;

import com.unlu.sdypp.renderizado.fileserver.entities.FileEntity;
import com.unlu.sdypp.renderizado.fileserver.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService service;

    @Autowired
    public FileController(FileService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<FileEntity> find(@RequestParam("file-name") String fileName) {
        return service.findByFileName(fileName);
    }

    @PutMapping("")
    public FileEntity save(@RequestParam("file") FileEntity entity) {
        return service.save(entity);
    }

    @DeleteMapping("")
    public void delete(@RequestParam("file") FileEntity entity) {
        service.delete(entity);
    }
}
