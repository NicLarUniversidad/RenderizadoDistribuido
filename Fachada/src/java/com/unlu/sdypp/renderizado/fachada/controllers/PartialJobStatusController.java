package com.unlu.sdypp.renderizado.fachada.controllers;

import java.util.List;

import com.unlu.sdypp.renderizado.fachada.models.PartialJobStatusEntity;
import com.unlu.sdypp.renderizado.fachada.services.PartialJobStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partial/job")
public class PartialJobStatusController {

    private final PartialJobStatusService service;

    @Autowired
    public PartialJobStatusController(PartialJobStatusService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<PartialJobStatusEntity> find(@RequestParam("reference") String refId) {
        return service.findByReference(refId);
    }
}
