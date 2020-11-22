package com.javaevangelist.sleuth.api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class PayserviceApplication {

	private static final Logger log = LoggerFactory.getLogger(PayserviceApplication.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getDiscount")
	public String addDiscount() {
		log.info("discount service called .....");
		return "added discount 20%";
	}
	
	@GetMapping("/payment")
	public String payment() {
		log.info("payment service called .....");
		return restTemplate.getForObject("http://localhost:8080/getDiscount", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PayserviceApplication.class, args);
	}

}
