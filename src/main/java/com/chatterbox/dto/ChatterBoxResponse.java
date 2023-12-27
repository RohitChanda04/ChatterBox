package com.chatterbox.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatterBoxResponse {

    private List<Choices> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choices {

        private int index;
        private ChatterBoxMessage message;

    }

}
