package com.assignment.SpringFramework;

import com.assignment.SpringFramework.looseCoupling.Music;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringFrameworkApplication.class, args);

		Music music = context.getBean(Music.class);
		music.play();

	}

}
