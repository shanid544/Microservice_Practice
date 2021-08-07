package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//insurance provider(server)--->link with github
@SpringBootApplication
@RestController
//((i got the box while i trying to get importfor rest controller)No live hover information available.
//Live hover providers use either spring-boot-actuator endpoints to retrieve information or the Spring live beans option. Consider adding spring-boot-actuator as a dependency to your project insurance-provider or enable the live beans option in your launch configuration
//)
@RequestMapping("insurance-service")
public class InsuranceProviderApplication {
	
	
	@GetMapping("/getAllPlans")
	public List<String> getPlans(){
		return Stream.of("Premium","Gold","Platinum").collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(InsuranceProviderApplication.class, args);
	}

}
