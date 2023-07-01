package com.hlis.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.hlis.exam"})
@EnableJpaRepositories(basePackages = {"com.hlis.exam.dao"})
public class SpringBootExam15JuneApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootExam15JuneApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExam15JuneApplication.class, args);
	}

}
