package com.github.tilnu.webquizengine.service;

import com.github.tilnu.webquizengine.model.Feedback;

public class FeedbackBuilder {
    public static Feedback wrongAnswer() {
        return new Feedback(true, "Congratulations, you're right!");
    }
    public static Feedback rightAnswer() {
        return new Feedback(false, "Wrong answer! Please, try again.");
    }
}
