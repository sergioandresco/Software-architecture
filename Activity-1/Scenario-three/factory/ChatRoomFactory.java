package factory;

import mediator.ChatRoom;
import model.User;

import java.util.*;

public class ChatRoomFactory {

    private final Map<String, ChatRoom> rooms;

    public ChatRoomFactory() {
        this.rooms = new HashMap<>();
    }

    public ChatRoom createRoom(String id, String name, int maxUsers) {
        ChatRoom room = new ChatRoom(id, name, maxUsers);
        rooms.put(id, room);
        return room;
    }

    public ChatRoom getRoom(String id) {
        return rooms.get(id);
    }

    public void deleteRoom(String id) {
        rooms.remove(id);
    }

    public List<ChatRoom> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }
}
