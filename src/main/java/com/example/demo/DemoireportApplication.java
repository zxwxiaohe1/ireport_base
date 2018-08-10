package com.example.demo;

import com.example.demo.action.IreportAction;
import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@ServletComponentScan
@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.serverce", "com.example.demo.action", "com.example.demo.config"})
public class DemoireportApplication {

	public static void main(String[] args) {
		SpringApplication.run(IreportAction.class, args);
	}
}
