package com.example.singleton;

import com.example.singleton.app.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonApplication.class, args);
	}

	public static void test() {
		Config config = Config.getInstance();
	}

}
