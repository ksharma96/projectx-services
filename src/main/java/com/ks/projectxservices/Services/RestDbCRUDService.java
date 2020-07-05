package com.ks.projectxservices.Services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Service
public class RestDbCRUDService {

    @Value("${restdb.xapikey}")
    private String xapikey;

    private String restDbBaseUrl = "https://logindata-e964.restdb.io/rest/logindata";

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> insertRecord(String record) {
        HttpHeaders headers = new HttpHeaders();
        headers = buildHeader();
        HttpEntity<String> requestEntity = new HttpEntity<>(record, headers);
        ResponseEntity<String> response = restTemplate.exchange(restDbBaseUrl, HttpMethod.POST, requestEntity, String.class);
        System.out.println(response.toString());
        return response;
    }

    public Boolean isUnique(String record) {


        return null;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private HttpHeaders buildHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", xapikey);
        headers.add("Content-Type", "application/json");
        return headers;
    }
}
