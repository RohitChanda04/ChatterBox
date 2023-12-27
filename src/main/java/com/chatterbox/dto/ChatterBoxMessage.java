package com.chatterbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatterBoxMessage {

    private String role; // the user who is accessing/using it
    private String content; // the prompt

}
