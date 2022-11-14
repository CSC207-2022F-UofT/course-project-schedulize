import entity_layer.CommonUserFactory;
import entity_layer.UserFactory;
import entity_layer.UserStorage;
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
        storage = new UserStorage();

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

    @After
    public void tearDown() {
        ((UserStorage) storage).removeUser("i'm a user");
    }
}
