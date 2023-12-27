package com.chatterbox;

import com.chatterbox.controller.ChatterBoxController;
import com.chatterbox.dto.ChatterBoxResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ChatterboxApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ChatterboxApplication.class, args);

		ChatterBoxController controller = new ChatterBoxController();
		controller.conversation();
	}

}
