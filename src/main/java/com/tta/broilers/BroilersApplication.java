package com.tta.broilers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author rym lamouchi
 *
 */
@SpringBootApplication
@EnableScheduling
public class BroilersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BroilersApplication.class, args);
	}

}
