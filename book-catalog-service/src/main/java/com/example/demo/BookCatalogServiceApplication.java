package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


//consuming MS
@SpringBootApplication
//@EnableEurekaClient(wiyhout these also it is working idk???)
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class BookCatalogServiceApplication {
	
	@Bean
	@LoadBalanced //it will goto resttemplate and try to find any hind regarding the url of MS(consumed by this MS.)
	              //as a hint we can add the name of servive instaed of localhost:port
	              // load balabcer have two responsblity.one is load balancing and sercive disovery
	public RestTemplate getRestTemplate() {
		
		//it is used to imliment timeout, to solve slow instavce problem 
		//for more refer diary april "hoe do we make MS resi     liend"
		//HttpComponenetsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponenetsClientHttpRequestFactory();
		//clientHttpRequestFactory.setTimeout(3000);
		//return new RestTemplate(clientHttpRequestFactory);
		return new RestTemplate();
	}
	 
	/*
	 * @Bean public WebClient.Builder getWebClientBuilder() {
	 * 
	 * return WebClient.builder(); }
	 */

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogServiceApplication.class, args);
	}

}
