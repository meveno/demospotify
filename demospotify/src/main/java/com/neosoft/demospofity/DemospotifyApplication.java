package com.neosoft.demospofity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.neosoft"})
public class DemospotifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospotifyApplication.class, args);
	}
}
