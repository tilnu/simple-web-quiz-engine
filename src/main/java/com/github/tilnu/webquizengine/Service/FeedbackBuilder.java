package com.github.tilnu.webquizengine.Service;

import com.github.tilnu.webquizengine.Model.Feedback;

public class FeedbackBuilder {
    public static Feedback wrongAnswer() {
        return new Feedback(true, "Congratulations, you're right!");
    }
    public static Feedback rightAnswer() {
        return new Feedback(false, "Wrong answer! Please, try again.");
    }
}
