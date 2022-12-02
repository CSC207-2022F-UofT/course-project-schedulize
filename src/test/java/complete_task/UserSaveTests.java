package complete_task;
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

public class UserSaveTests {

    private static SaveUserController saveController;
    private static UserDataStoreGateway storage;

    @BeforeAll
    public static void setUp() {
        Cryptograph cipher = new CommonCryptograph();
        storage = new UserStorage(cipher);
        SaveUserInputBoundary interactor = new SaveUserInteractor(storage);
        saveController = new SaveUserController(interactor);
    }

    @Test
    public void testNonExistingUserSave() {
        saveController.saveInMemoryUser();
    }

    @Test
    public void testExistingUserSave() throws IOException {
        InMemoryUser.setActiveUser(new CommonUser("abba", "abba@band.com", "password10"));
        saveController.saveInMemoryUser();
        storage.loadUser("abba", "password10");
    }
}
