package use_cases.save_user;

import config.UserDataStoreGateway;
import entity_layer.InMemoryUser;
import entity_layer.User;

import java.io.IOException;

/**
 * An interactor for saving the user that has been loaded into the program's memory
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class SaveUserInteractor implements SaveUserInputBoundary {
    private final UserDataStoreGateway storage;

    /**
     * A constructor that sets this interactor's storage
     * @param storage the data storage that can save users
     */
    public SaveUserInteractor(UserDataStoreGateway storage) {
        this.storage = storage;
    }

    /**
     * Saves the user loaded into the memory
     */
    @Override
    public void saveInMemoryUser() {
        User toSave = InMemoryUser.getActiveUser();
        try {
            if (toSave != null) {
                storage.saveUser(toSave);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
