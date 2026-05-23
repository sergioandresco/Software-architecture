package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

    private final String id;
    private final User sender;
    private final User receiver;
    private final String content;
    private final LocalDateTime timestamp;
    private final MessageType type;

    public Message(User sender, String content, MessageType type, User receiver) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.type = type;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public boolean isPrivate(){
        return receiver != null;
    }

    @Override
    public String toString() {
        if(isPrivate()){
            return "[PRIVATE] " + sender.getName() + " -> " + receiver.getName() + ":" + content;
        }
        return sender.getName() + ": " + content;
    }
}
