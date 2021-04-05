package com.unlu.sdypp.renderizado.fachada.repositories;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Repository
public class HttpRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Object httpRequest(HttpMethod httpMethod, String uri, HashMap<String, Object> params, Class<?> classRef) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        for (HashMap.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            builder = builder.queryParam(key, value);
        }
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<?> response = restTemplate.exchange(
                builder.toUriString(),
                httpMethod,
                entity,
                classRef);
        return response.getBody();
    }
}
