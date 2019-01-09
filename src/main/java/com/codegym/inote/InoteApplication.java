package com.codegym.inote;

import com.codegym.inote.formatter.NotetypeFormatter;
import com.codegym.inote.service.INoteService;
import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.impl.INoteServiceImpl;
import com.codegym.inote.service.impl.NotetypeServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;

@SpringBootApplication
public class InoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(InoteApplication.class, args);
	}

	@Bean
	public INoteService iNoteService(){
		return new INoteServiceImpl();
	}

	@Bean
	public NotetypeService notetypeService(){
		return new NotetypeServiceImpl();
	}

}

