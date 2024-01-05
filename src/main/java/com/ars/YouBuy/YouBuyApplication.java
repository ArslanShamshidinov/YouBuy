package com.ars.YouBuy;

import com.ars.YouBuy.common.property.FileStorageProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({FileStorageProperty.class})

@SpringBootApplication
public class YouBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouBuyApplication.class, args);
	}

}
