package mediator;

import model.User;

public interface ChatMediator {

    void register(User user);

    void unregister(User user);

    void sendMessage(User sender, String content);

    void sendPrivateMessage(User sender, User receiver, String content);
}
