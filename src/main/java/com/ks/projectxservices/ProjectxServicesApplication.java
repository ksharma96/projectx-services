package com.ks.projectxservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectxServicesApplication {


	public static void main(String[] args) {
		try {
			SpringApplication.run(ProjectxServicesApplication.class, args);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
