package com.springboot.beautyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springboot.beautyshop.config.AppConfig;
import com.springboot.beautyshop.service.UserServiceImpl;

@SpringBootApplication
public class BeautyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyShopApplication.class, args);
	}

}