import use_cases.user_registration.UserRegistrationController;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import entity_factories.CommonUserFactory;
import entity_layer.UserFactory;
import config.UserStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import use_cases.user_registration.*;


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
        controller.create("email@sample.com", "i'm a user", "password", "password");
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
