package com.chatterbox.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatterBoxRequest {

    private String model; // the GPT model being accessed
    private List<ChatterBoxMessage> messages;

//    public ChatterBoxRequest(String model, String prompt) {
//        super();
//        this.model = model;
//        this.messages = new ArrayList<>();
//        this.messages.add(new ChatterBoxMessage("user", prompt));
//    }


    public ChatterBoxRequest(String model, List<ChatterBoxMessage> messages) {
        this.model = model;
        this.messages = messages;
    }
}
