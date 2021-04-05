package com.unlu.sdypp.renderizado.fachada.controllers;

import com.unlu.sdypp.renderizado.fachada.models.FileEntity;
import com.unlu.sdypp.renderizado.fachada.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
