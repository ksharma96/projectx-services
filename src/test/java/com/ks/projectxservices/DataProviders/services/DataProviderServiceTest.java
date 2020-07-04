package com.ks.projectxservices.DataProviders.services;

import org.junit.Test;

import java.io.IOException;


public class DataProviderServiceTest {

    DataProviderService dataProviderService = new DataProviderService();

    @Test
    public void herokuUnofficialTest() throws IOException {
        System.out.println(dataProviderService.getHerokuUnofficialData());
    }

}