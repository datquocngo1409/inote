package com.codegym.inote;

import com.codegym.inote.service.INoteService;
import com.codegym.inote.service.impl.INoteServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InoteApplication.class, args);
	}

	@Bean
	public INoteService iNoteService(){
		return new INoteServiceImpl();
	}
}

