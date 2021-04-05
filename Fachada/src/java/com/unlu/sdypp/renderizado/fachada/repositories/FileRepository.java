package com.unlu.sdypp.renderizado.fachada.repositories;

import com.unlu.sdypp.renderizado.fachada.models.FileEntity;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class FileRepository {

    @Value("${file-server.uri}")
    private String fileServerUri;

    private final RestTemplate restTemplate;

    private final HttpRepository httpRepository;

    @Autowired
    public FileRepository(RestTemplate restTemplate, HttpRepository httpRepository) {
        this.restTemplate = restTemplate;
        this.httpRepository = httpRepository;
    }

    public List<FileEntity> getFilesByName(String fileName) {
        String url = fileServerUri + "/files";
        HashMap<String, Object> params = new HashMap<>();
        params.put("file-name", fileName);
        return (List<FileEntity>) httpRepository.httpRequest(HttpMethod.GET, url, params, List.class);
    }

    public FileEntity saveFile(FileEntity entity) {
        String url = fileServerUri + "/files";
        HashMap<String, Object> params = new HashMap<>();
        params.put("file", entity);
        return (FileEntity) httpRepository.httpRequest(HttpMethod.PUT, url, params, FileEntity.class);
    }

    public void deleteFile(FileEntity entity) {
        String url = fileServerUri + "/files";
        HashMap<String, Object> params = new HashMap<>();
        params.put("file", entity);
        httpRepository.httpRequest(HttpMethod.DELETE, url, params, Object.class);
    }
}
