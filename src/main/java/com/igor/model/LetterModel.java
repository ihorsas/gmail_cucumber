package com.igor.model;

import java.util.Objects;

public class LetterModel {
    private String receiver;
    private String topic;
    private String message;

    public LetterModel(String receiver, String topic, String message) {
        this.receiver = receiver;
        this.topic = topic;
        this.message = message;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LetterModel)) return false;
        LetterModel letterModel = (LetterModel) o;
        return Objects.equals(getReceiver(), letterModel.getReceiver()) &&
                Objects.equals(getTopic(), letterModel.getTopic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiver(), getTopic());
    }
}
