package entity_layer;

/**
 * A Singleton class for managing the User in the program's memory
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class InMemoryUser {
    private User loadedUser;
    private static InMemoryUser instance;

    /**
     * Singleton constructor
     */
    private InMemoryUser() {}

    /**
     * creates an instance of this class if there is not one already
     * @return instance of this class
     */
    private static InMemoryUser getInstance() {
        if (instance == null) {
            instance = new InMemoryUser();
        }
        return instance;
    }

    /**
     * Sets the User to be referenced in the program's memory
     * @param user new user to reference throughout interactors
     */
    public static void setActiveUser(User user) {
        getInstance().loadedUser = user;
    }

    /**
     * @return the User that has been loaded into the program's memory (logged in)
     */
    public static User getActiveUser() {
        return getInstance().loadedUser;
    }
}
