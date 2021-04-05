package com.unlu.sdypp.renderizado.fachada.controllers;

import com.unlu.sdypp.renderizado.fachada.models.JobStatusEntity;
import com.unlu.sdypp.renderizado.fachada.services.JobStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobStatusController {

    private final JobStatusService service;

    @Autowired
    public JobStatusController(JobStatusService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<JobStatusEntity> find(@RequestParam("reference") String refId) {
        return service.findByReference(refId);
    }
}
