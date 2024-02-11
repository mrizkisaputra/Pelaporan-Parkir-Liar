package com.mrizkisaputra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
		@PropertySource("classpath:/database.properties")
})
@SpringBootApplication
public class PelaporanParkirLiarApplication {

	public static void main(String[] args) {
		SpringApplication.run(PelaporanParkirLiarApplication.class, args);
	}

}
