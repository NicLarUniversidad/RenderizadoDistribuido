package com.unlu.sdypp.renderizado.fachada.repositories;

import com.unlu.sdypp.renderizado.fachada.models.PartialJobStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Repository
public class PartialJobStatusRepository {

    @Value("${file-server.uri}")
    private String fileServerUri;

    private final RestTemplate restTemplate;

    private final HttpRepository httpRepository;

    @Autowired
    public PartialJobStatusRepository(RestTemplate restTemplate, HttpRepository httpRepository) {
        this.restTemplate = restTemplate;
        this.httpRepository = httpRepository;
    }

    public List<PartialJobStatusEntity> getFilesByReference(String reference) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("reference", reference);
        return (List<PartialJobStatusEntity>) httpRepository.httpRequest(HttpMethod.GET, url, params, List.class);
    }

    public PartialJobStatusEntity save(PartialJobStatusEntity entity) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("partial-job-status", entity);
        return (PartialJobStatusEntity) httpRepository.httpRequest(HttpMethod.PUT, url, params, PartialJobStatusEntity.class);
    }

    public void delete(PartialJobStatusEntity entity) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("partial-job-status", entity);
        httpRepository.httpRequest(HttpMethod.DELETE, url, params, Object.class);
    }
}
