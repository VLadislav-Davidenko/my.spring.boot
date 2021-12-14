package com.example.my.spring.boot;

import com.example.my.spring.boot.service.ExportReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class Application {

	@Autowired
	private ExportReportService exportReportService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onStart() throws IOException {
		log.info("I am ready!!!");
		exportReportService.export();
	}
}
