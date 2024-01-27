package com.chatterbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.chatterbox.dto.ChatterBoxRequest;
import com.chatterbox.dto.ChatterBoxResponse;
import com.chatterbox.dto.ChatterBoxMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/chatterbox")
public class ChatterBoxController {

    final static private String RESET = "\u001B[0m";
    final static private String MAGENTA = "\u001B[35m";
    final static private String RED = "\u001B[31m";
    final static private String YELLOW = "\u001B[33m";
    final static private String CYAN = "\u001B[36m";

    @Value("${openai.api.model}")
    private String model;

    @Value("${openai.api.url}")
    private String url;

    @Autowired
    private RestTemplate template;

    private List<ChatterBoxMessage> conversationHistory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private String answer = "";

    @PostMapping("/chat")
    public void conversation() throws InterruptedException {

        final String text1 = "Welcome to ChatterBox!\n\nAsk anything!\nOr type ";
        final String text2 = "'exit'";
        final String text3 = "to exit.\n";
        final String text4 = " Ask a follow-up or a new question. Type ";

        // streaming on console
        System.out.println("\n"+CYAN);

        for(char ch : text1.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(15);
        }

        System.out.print(RESET+RED);

        for(char ch : text2.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(15);
        }

        System.out.print(RESET+CYAN);

        for(char ch : text3.toCharArray()) {
            System.out.print(ch);
            Thread.sleep(15);
        }

        System.out.print(RESET);


        // business logic
        while(true) {
            System.out.print("\n"+MAGENTA+"You: "+RESET);
            String query = scanner.nextLine();

            if(query.equalsIgnoreCase("exit")) {
                System.out.println("\n"+CYAN+"Goodbye!");
                System.exit(0);
                break;
            }

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject("http://localhost:8080/chatterbox/chat?prompt=" + query, ChatterBoxResponse.class);


            // streaming on console
            System.out.print(CYAN+"ChatterBox:"+YELLOW);

            for(char ch : text4.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(15);
            }

            System.out.print(RESET+RED);

            for(char ch : text2.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(15);
            }

            System.out.print(RESET+CYAN);

            for(char ch : text3.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(15);
            }

            System.out.print(RESET);
        }
    }

    @GetMapping("/chat")
    public void chat(@RequestParam("prompt") String prompt) throws InterruptedException {
        conversationHistory.add(new ChatterBoxMessage("user", prompt));

        ChatterBoxRequest request = new ChatterBoxRequest(model, conversationHistory);
        ChatterBoxResponse response = template.postForObject(url, request, ChatterBoxResponse.class);

        answer = response.getChoices().get(0).getMessage().getContent();
        System.out.print("\n"+CYAN+"ChatterBox: "+RESET);

        for(char ch : answer.toCharArray()) {
            System.out.print(YELLOW + Character.toString(ch));
            Thread.sleep(6);
        }

        System.out.println(RESET+"\n");

        conversationHistory.add(new ChatterBoxMessage("assistant", answer));
    }

}
