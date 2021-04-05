package com.unlu.sdypp.renderizado.fachada.repositories;

import com.unlu.sdypp.renderizado.fachada.models.PartialJobEntity;
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

    public List<PartialJobEntity> getFilesByReference(String reference) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("reference", reference);
        return (List<PartialJobEntity>) httpRepository.httpRequest(HttpMethod.GET, url, params, List.class);
    }

    public PartialJobEntity save(PartialJobEntity entity) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("partial-job-status", entity);
        return (PartialJobEntity) httpRepository.httpRequest(HttpMethod.PUT, url, params, PartialJobEntity.class);
    }

    public void delete(PartialJobEntity entity) {
        String url = fileServerUri + "/partial/job";
        HashMap<String, Object> params = new HashMap<>();
        params.put("partial-job-status", entity);
        httpRepository.httpRequest(HttpMethod.DELETE, url, params, Object.class);
    }
}
