package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.EstudianteCarreraRepositoryImpl;
import com.example.demo.utils.LoadDatabase;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private LoadDatabase LoadDatabase;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}	

	@PostConstruct
	public void init() throws IOException {
		LoadDatabase.initDatabase();
	}


}