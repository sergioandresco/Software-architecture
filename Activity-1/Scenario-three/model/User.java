package model;

import mediator.ChatRoom;

public class User {

    private final String id;
    private final String name;
    private UserStatus status;
    private ChatRoom chatRoom;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = UserStatus.ONLINE;
    }

    public String getName() {
        return name;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void joinRoom(ChatRoom room) {
        this.chatRoom = room;
        room.register(this);
    }

    public void leaveRoom() {
        if (chatRoom != null) {
            chatRoom.unregister(this);
            chatRoom = null;
        }
    }

    public void sendMessage(String content) {
        if (chatRoom != null) {
            chatRoom.sendMessage(this, content);
        }
    }

    public void receiveMessage(Message message) {
        System.out.println("[" + name + " receives] " + message);
    }

    public void sendPrivateMessage(User receiver, String content) {
        if (chatRoom != null) {
            chatRoom.sendPrivateMessage(this, receiver, content);
        }
    }
}

