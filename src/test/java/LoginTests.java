import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import entity_factories.CommonUser;
import entity_layer.InMemoryUser;
import entity_layer.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import use_cases.login.LoginController;
import use_cases.login.LoginException;
import use_cases.login.LoginInteractor;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {

    static UserDataStoreGateway storage;
    static User user;
    static LoginInteractor interactor;
    static LoginController controller;

    @BeforeAll
    public static void setUp() throws IOException {
        Cryptograph cipher = new CommonCryptograph();

        storage = new UserStorage(cipher);
        user = new CommonUser("Shelly", "shale@lalal.com", "password1");
        storage.saveUser(user);

        interactor = new LoginInteractor(storage);
        controller = new LoginController(interactor);
    }

    @Test
    public void testSuccessfulLogin() {
        controller.login("Shelly", "password1");
        User actualUser = InMemoryUser.getActiveUser();

        // check that expected and actual fields are the same
        assertEquals(user.getUsername(), actualUser.getUsername());
        assertEquals(user.getPassword(), actualUser.getPassword());
        assertEquals(user.getEmail(), actualUser.getEmail());
    }

    @Test
    public void testExistingUserWrongPassword() {
        try {
            controller.login("Shelly", "password");
        } catch (LoginException e) { return; }

        // should not be reached
        throw new RuntimeException();
    }

    @Test
    public void testNotExistingUser() {
        try {
            controller.login("She", "password1");
        } catch (LoginException e) { return; }

        // should not be reached
        throw new RuntimeException();
    }
}
