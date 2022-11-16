package use_cases.login;

import config.DataStorageMalfunction;
import entity_layer.UserFactory;
import config.UserDataStoreGateway;

import java.io.IOException;
import java.io.StreamCorruptedException;

public class LoginInteractor implements LoginInputBoundary {
    private final UserDataStoreGateway storage;
    public LoginInteractor(UserDataStoreGateway dataStorage) {
        this.storage = dataStorage;
    }

    public void login(LoginRequest request) throws LoginException {
        try {
            storage.loadUser(request.getUsername(), request.getPassword());
        } catch (IOException error) {
            throw new LoginException("Invalid username or password.");
        } catch (DataStorageMalfunction error) {
            throw new LoginException("Fatal Error: " + error.getMessage());
        }
    }
}
