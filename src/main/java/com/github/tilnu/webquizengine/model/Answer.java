package com.github.tilnu.webquizengine.model;

import org.springframework.stereotype.Component;

@Component
public class Answer {
    private int[] answer;


    public Answer() {
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
