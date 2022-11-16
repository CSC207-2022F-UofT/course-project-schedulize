package use_cases.login;

import config.DataStorageMalfunction;
import entity_layer.UserFactory;
import config.UserDataStoreGateway;

import java.io.IOException;
import java.io.StreamCorruptedException;

public class LoginInteractor implements LoginInputBoundary {
    private final UserFactory userFactory;
    private final UserDataStoreGateway storage;
    public LoginInteractor(UserFactory userFactory, UserDataStoreGateway dataStorage) {
        this.userFactory = userFactory;
        this.storage = dataStorage;
    }

    public void login(LoginRequest request) throws LoginException {
        if (storage.usernameExists(request.getUsername())) {
            try {
                storage.loadUser(request.getUsername(), request.getPassword());
            } catch (IOException error) {
                throw new LoginException("Invalid username or password.");
            } catch (DataStorageMalfunction error) {
                throw new LoginException("Fatal Error: " + error.getMessage());
            }
        }
    }
}
