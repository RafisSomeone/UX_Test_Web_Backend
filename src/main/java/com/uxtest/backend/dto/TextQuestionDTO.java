package com.uxtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.uxtest.backend.model.questionnaire.question.TextQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextQuestionDTO {

    @JsonProperty
    private String content;

    public TextQuestion parseTextQuestion() {
        return TextQuestion.builder()
                .content(getContent())
                .build();
    }
}