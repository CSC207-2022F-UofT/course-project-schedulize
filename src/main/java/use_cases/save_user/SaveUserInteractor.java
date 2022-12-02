package use_cases.save_user;

import config.UserDataStoreGateway;
import entity_layer.InMemoryUser;
import entity_layer.User;

import java.io.IOException;

public class SaveUserInteractor implements SaveUserInputBoundary {
    private final UserDataStoreGateway storage;

    public SaveUserInteractor(UserDataStoreGateway storage) {
        this.storage = storage;
    }

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
