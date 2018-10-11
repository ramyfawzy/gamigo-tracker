package com.gamigo.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(TrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);

		ApplicationContext ctx = SpringApplication.run(TrackerApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		for (String s : beans) {
			log.info(s);
		}

	}
}
