package com.chatterbox;

import com.chatterbox.controller.ChatterBoxController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatterboxApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ChatterboxApplication.class, args);

		ChatterBoxController controller = new ChatterBoxController();
		controller.conversation();
	}

}
