package com.unlu.sdypp.renderizado.fileserver.controllers;

import com.unlu.sdypp.renderizado.fileserver.entities.JobStatusEntity;
import com.unlu.sdypp.renderizado.fileserver.services.JobStatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("")
    public JobStatusEntity save(@RequestParam("job-status") JobStatusEntity entity) {
        return service.save(entity);
    }

    @DeleteMapping("")
    public void delete(@RequestParam("job-status") JobStatusEntity entity) {
        service.delete(entity);
    }
}
