package com.cysout.springboot.app.item.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	//Registrar el Beans para poder inyectarlo posteriormente en ItemServiceImpl
	@Bean("clienteRest")
	@LoadBalanced
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
}
