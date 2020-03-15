package com.arun.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.arun.phonebook.app.PhoneBookController;
import com.arun.phonebook.app.PhoneBookService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		PhoneBookController bookController = run.getBean(PhoneBookController.class);
		bookController.getAllContacts();
	}
}
