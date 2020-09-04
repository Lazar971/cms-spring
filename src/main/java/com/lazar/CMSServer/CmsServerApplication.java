package com.lazar.CMSServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lazar.CMSServer.repository")
public class CmsServerApplication {

	public static void main(String[] args) {
            System.out.println("Working");
		SpringApplication.run(CmsServerApplication.class, args);
	}

}
