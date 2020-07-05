package com.ks.projectxservices.Controllers;

import com.ks.projectxservices.Services.RestDbCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDbController {

    @Autowired
    RestDbCRUDService restDbCRUDService;

    @PostMapping("/restdb/insert")
    public ResponseEntity<String> insertRecords(@RequestBody String record) {
        System.out.println(record);
        return restDbCRUDService.insertRecord(record);
    }
}
