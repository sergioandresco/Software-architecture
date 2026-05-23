package mediator;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private final String id;
    private final String name;
    private final int maxUsers;
    private final List<User> users;
    private final List<Message> messageHistory;

    public ChatRoom(String id, String name, int maxUsers) {
        this.id = id;
        this.name = name;
        this.maxUsers = maxUsers;

        this.users = new ArrayList<>();
        this.messageHistory = new ArrayList<>();
    }

    @Override
    public void register(User user) {
        if(users.size() >= maxUsers) {
            System.out.println("The chat room has reached the maximum number of users.");
            return;
        }

        users.add(user);

        Message systemMessage = new Message(new SystemUser(), user.getName() + " joined the chat.", MessageType.SYSTEM, null);

        broadcast(systemMessage);
    }

    @Override
    public void unregister(User user) {
        users.remove(user);

        Message systemMessage = new Message(new SystemUser(), user.getName() + " left the chat.", MessageType.SYSTEM, null);

        broadcast(systemMessage);
    }

    @Override
    public void sendMessage(User sender, String content) {
        Message message = new Message(sender, content, MessageType.TEXT, null);
        messageHistory.add(message);
        broadcast(message);
    }

    @Override
    public void sendPrivateMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, content, MessageType.TEXT, receiver);
        messageHistory.add(message);
        receiver.receiveMessage(message);
    }

    private void broadcast(Message message) {
        for (User user : users) {
            if (user != message.getSender()) {
                user.receiveMessage(message);
            }
        }
    }

    public void showHistory() {
        System.out.println("----- CHAT HISTORY -----");

        for (Message message : messageHistory) {
            System.out.println(message);
        }
    }
}
