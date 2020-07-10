package com.ks.projectxservices.Services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public ResponseEntity<String> insertRecordIfUnique(String record) {

        if (isUnique(record)) {

            HttpHeaders headers = new HttpHeaders();
            headers = buildHeader();
            HttpEntity<String> requestEntity = new HttpEntity<>(record, headers);
            ResponseEntity<String> response = restTemplate.exchange(restDbBaseUrl, HttpMethod.POST, requestEntity, String.class);
            System.out.println(response.toString());
            return response;

        } else {
            ResponseEntity<String> responseEntity = new ResponseEntity<String>("Record already exists", HttpStatus.valueOf(400));
            return responseEntity;
        }
    }

    public Boolean isUnique(String record) {
        JSONObject recordJson = new JSONObject(record);
        String username = null;

        if (recordJson.has("username")) {
            username = recordJson.getString("username");

        }
        if (username != null) {

            StringBuilder urlToRetrieveArrayOfUsernames = new StringBuilder(restDbBaseUrl);
            urlToRetrieveArrayOfUsernames.append("?q={\"username\":\"" + username + "\"}");
            System.out.println(urlToRetrieveArrayOfUsernames);
            HttpHeaders headers = new HttpHeaders();
            headers = buildHeader();
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(urlToRetrieveArrayOfUsernames.toString(), HttpMethod.GET, requestEntity, String.class, 1);

            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("Request Successful.");
                System.out.println(response.getBody());
            } else {
                System.out.println("Request Failed");
                System.out.println(response.getStatusCode());
            }

            JSONArray arrayOfUsers = new JSONArray(response.getBody().toString());

            if (arrayOfUsers.isEmpty())
                return true;
            else return false;
        }
        System.out.println("Error getting username related data from RestDB");
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
