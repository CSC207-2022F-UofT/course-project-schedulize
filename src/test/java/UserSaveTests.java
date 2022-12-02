import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import entity_layer.CommonUser;
import entity_layer.InMemoryUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import use_cases.save_user.SaveUserController;
import use_cases.save_user.SaveUserInputBoundary;
import use_cases.save_user.SaveUserInteractor;

import java.io.IOException;

/**
 * A testing suite for the save_user use case
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class UserSaveTests {

    private static SaveUserController saveController;
    private static UserDataStoreGateway storage;

    /**
     * Creates necessary objects for tests
     */
    @BeforeAll
    public static void setUp() {
        Cryptograph cipher = new CommonCryptograph();
        storage = new UserStorage(cipher);
        SaveUserInputBoundary interactor = new SaveUserInteractor(storage);
        saveController = new SaveUserController(interactor);
    }

    /**
     * Tests that trying to save the User loaded into memory, when one has not been loaded, does not produce an
     * exception
     */
    @Test
    public void testNonExistingUserSave() {
        saveController.saveInMemoryUser();
    }

    /**
     * Tests saving a User that has been loaded into memory and then retrieving that User
     * @throws IOException thrown if drivers are not correctly connected
     */
    @Test
    public void testExistingUserSave() throws IOException {
        InMemoryUser.setActiveUser(new CommonUser("abba", "abba@band.com", "password10"));
        saveController.saveInMemoryUser();
        storage.loadUser("abba", "password10");
    }
}
