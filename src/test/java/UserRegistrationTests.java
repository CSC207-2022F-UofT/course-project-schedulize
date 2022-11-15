import UI.UserRegistrationController;
import UI.UserRegistrationResponseFormatter;
import config.CommonCryptograph;
import config.Cryptograph;
import entity_layer.CommonUserFactory;
import entity_layer.UserFactory;
import config.UserStorage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import use_cases.user_registration.*;


public class UserRegistrationTests {
    UserRegistrationController controller;
    UserRegistrationInputBoundary interactor;
    UserRegistrationPresenter presenter;
    UserDataStoreGateway storage;

    @Before
    public void setUp() {
        testPresenterInitialization();
        testInteractorInitialization();
        testControllerInitialization();
    }

    @Test(timeout = 50)
    public void testPresenterInitialization() {
        presenter = new UserRegistrationResponseFormatter();
    }

    @Test(timeout = 50)
    public void testInteractorInitialization() {
        UserFactory factory = new CommonUserFactory();
        Cryptograph cipher = new CommonCryptograph();
        storage = new UserStorage(cipher);

        interactor = new UserRegistrationInteractor(factory, storage, presenter);
    }

    @Test(timeout = 50)
    public void testControllerInitialization() {
        controller = new UserRegistrationController(interactor);
    }

    @Test(timeout = 50)
    public void testControllerUserCreation() {
        controller.create("email@sample.com", "i'm a user", "password", "password");
    }

    @Test(timeout = 50)
    public void testControllerExisitngUser() {
        controller.create("email@sample.com", "user person", "password", "password");
        try {
            controller.create("email@sample.com", "user person", "password", "password");
        } catch (UserRegistrationError error){
            return;
        }

        throw new RuntimeException();
    }

    @Test(timeout = 50)
    public void testControllerPasswordNotLongEnough() {
        try {
            controller.create("email@sample.com", "user person", "p", "p");
        } catch (UserRegistrationError error){
            return;
        }

        throw new RuntimeException();
    }

    @Test(timeout = 50)
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

    @Test(timeout = 50)
    public void testControllerPasswordsDontMatch() {
        try {
            controller.create("email@samplecom", "user person", "passwora;aad",
                    "passwo;lasrd");
        } catch (UserRegistrationError ignored){
            return;
        }

        throw new RuntimeException();
    }

    @After
    public void tearDown() {
        ((UserStorage) storage).removeUser("i'm a user");
        ((UserStorage) storage).removeUser("user person");
    }
}
