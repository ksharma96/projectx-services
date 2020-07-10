package com.ks.projectxservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
