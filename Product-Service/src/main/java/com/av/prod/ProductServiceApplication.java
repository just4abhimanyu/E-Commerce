package com.av.prod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
