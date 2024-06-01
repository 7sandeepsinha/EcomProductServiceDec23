package dev.sandeep.EcomProductServiceDec23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcomProductServiceDec23Application {

	public static void main(String[] args) {
		SpringApplication.run(EcomProductServiceDec23Application.class, args);
	}

}
