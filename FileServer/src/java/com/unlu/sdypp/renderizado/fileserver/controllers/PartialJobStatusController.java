package com.unlu.sdypp.renderizado.fileserver.controllers;

import com.unlu.sdypp.renderizado.fileserver.entities.PartialJobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.services.PartialJobStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return service.findByJobReference(refId);
    }

    @PutMapping("")
    public PartialJobStatusEntity save(@RequestParam("partial-job-status") PartialJobStatusEntity entity) {
        return service.save(entity);
    }

    @DeleteMapping("")
    public void delete(@RequestParam("partial-job-status") PartialJobStatusEntity entity) {
        service.delete(entity);
    }
}
