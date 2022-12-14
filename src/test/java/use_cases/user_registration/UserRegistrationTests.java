package use_cases.user_registration;

import entity_layer.InMemoryUser;
import entity_layer.User;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import entity_factories.CommonUserFactory;
import entity_factories.UserFactory;
import config.UserStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserRegistrationTests {
    static UserRegistrationController controller;
    static UserRegistrationInputBoundary interactor;
    static UserDataStoreGateway storage;

    @BeforeAll
    public static void setUp() {
        UserFactory factory = new CommonUserFactory();
        Cryptograph cipher = new CommonCryptograph();
        storage = new UserStorage(cipher);

        interactor = new UserRegistrationInteractor(factory, storage);
        controller = new UserRegistrationController(interactor);
    }

    @Test
    public void testControllerUserCreation() {
        UserFactory factory = new CommonUserFactory();
        User expectedUser = factory.create("i'm a user","email@sample.com",  "password");

        controller.create("email@sample.com", "i'm a user", "password", "password");
        User actualUser = InMemoryUser.getActiveUser();

        // check that expected and actual fields are the same
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.getPassword(), actualUser.getPassword());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
    }

    @Test
    public void testControllerExisitngUser() {
        controller.create("email@sample.com", "user person", "password", "password");
        try {
            controller.create("email@sample.com", "user person", "password", "password");
        } catch (UserRegistrationError error){
            return;
        }

        throw new RuntimeException();
    }

    @Test
    public void testControllerPasswordNotLongEnough() {
        try {
            controller.create("email@sample.com", "user person", "p", "p");
        } catch (UserRegistrationError error){
            return;
        }

        throw new RuntimeException();
    }

    @Test
    public void testControllerInvalidEmails() {
        try {
            controller.create("email@samplecom", "user person", "password", "password");
            throw new RuntimeException("invalid email did not fail");
        } catch (UserRegistrationError ignored){}

        try {
            controller.create("emailsample.com", "user person", "password", "password");
        } catch (UserRegistrationError error){
            return;
        }

        throw new RuntimeException();
    }

    @Test
    public void testControllerPasswordsDontMatch() {
        try {
            controller.create("email@samplecom", "user person", "passwora;aad",
                    "passwo;lasrd");
        } catch (UserRegistrationError ignored){
            return;
        }

        throw new RuntimeException();
    }

    @AfterAll
    public static void tearDown() {
        ((UserStorage) storage).removeUser("i'm a user");
        ((UserStorage) storage).removeUser("user person");
    }
}
