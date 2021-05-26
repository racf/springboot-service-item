package com.cysout.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@RibbonClient(name = "service-products")
@EnableFeignClients
@EnableEurekaClient
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
