package com.hcz.buy_detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BuyDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyDetailApplication.class, args);
	}

}
