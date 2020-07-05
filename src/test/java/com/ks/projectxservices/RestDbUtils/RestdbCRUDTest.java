package com.ks.projectxservices.RestDbUtils;

import com.ks.projectxservices.Utils.EnvironmentProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@RunWith(MockitoJUnitRunner.class)
public class RestdbCRUDTest {

    @InjectMocks
    EnvironmentProperties envProps = new EnvironmentProperties();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void tester() {

        System.out.println(envProps.getXapikey());
    }


}