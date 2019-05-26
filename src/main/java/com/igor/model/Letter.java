package com.igor.model;

import java.util.Objects;

public class Letter {
    private String receiver;
    private String topic;
    private String message;

    public Letter(String receiver, String topic, String message) {
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
        if (!(o instanceof Letter)) return false;
        Letter letter = (Letter) o;
        return Objects.equals(getReceiver(), letter.getReceiver()) &&
                Objects.equals(getTopic(), letter.getTopic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiver(), getTopic());
    }
}
