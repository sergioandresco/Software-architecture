import factory.ChatRoomFactory;
import mediator.ChatRoom;
import model.User;

public class Main {

    public static void main(String[] args) {
        ChatRoomFactory factory = new ChatRoomFactory();

        ChatRoom generalRoom = factory.createRoom("001", "General Room", 10);

        User john = new User("User1", "John");
        User camila = new User("User2", "Camila");
        User david = new User("User3", "David");

        john.joinRoom(generalRoom);
        camila.joinRoom(generalRoom);
        david.joinRoom(generalRoom);

        System.out.println();

        john.sendMessage("Hello team");
        camila.sendMessage("Hi John");
        david.sendMessage("Hello everyone");

        System.out.println();
        david.leaveRoom();

        System.out.println();
        john.sendPrivateMessage(camila, "Can you help me with the project?");
        camila.sendPrivateMessaje(john, "Yes");
        
        System.out.println();
        generalRoom.showHistory();
    }
}
