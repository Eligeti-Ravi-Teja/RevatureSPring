package org.example.event;

public class AtmEvent {
    private String message;

    public AtmEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
