package com.unlu.sdypp.renderizado.fachada.repositories;

import com.unlu.sdypp.renderizado.fachada.models.JobStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Repository
public class JobStatusRepository {

    @Value("${file-server.uri}")
    private String fileServerUri;

    private final RestTemplate restTemplate;

    private final HttpRepository httpRepository;

    @Autowired
    public JobStatusRepository(RestTemplate restTemplate, HttpRepository httpRepository) {
        this.restTemplate = restTemplate;
        this.httpRepository = httpRepository;
    }

    public List<JobStatusEntity> getFilesByReference(String reference) {
        String url = fileServerUri + "/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("reference", reference);
        return (List<JobStatusEntity>) httpRepository.httpRequest(HttpMethod.GET, url, params, List.class);
    }

    public JobStatusEntity save(JobStatusEntity entity) {
        String url = fileServerUri + "/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("job-status", entity);
        return (JobStatusEntity) httpRepository.httpRequest(HttpMethod.PUT, url, params, JobStatusEntity.class);
    }

    public void delete(JobStatusEntity entity) {
        String url = fileServerUri + "/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("job-status", entity);
        httpRepository.httpRequest(HttpMethod.DELETE, url, params, Object.class);
    }
}
