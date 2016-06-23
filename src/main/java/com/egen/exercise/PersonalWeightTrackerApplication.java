package com.egen.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class PersonalWeightTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalWeightTrackerApplication.class, args);
	}

}

@Configuration
@ImportResource("classpath:context.xml")
class XmlImportingConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}
}
