package entity_layer;

public class InMemoryUser {
    private User loadedUser;
    private static InMemoryUser instance;

    private InMemoryUser() {}

    private static InMemoryUser getInstance() {
        if (instance == null) {
            instance = new InMemoryUser();
        }
        return instance;
    }

    public static void setActiveUser(User user) {
        getInstance().loadedUser = user;
    }

    public static User getActiveUser() {
        return getInstance().loadedUser;
    }
}
