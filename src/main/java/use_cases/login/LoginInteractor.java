package use_cases.login;

import config.DataStorageMalfunction;
import entity_layer.InMemoryUser;
import entity_layer.User;
import config.UserDataStoreGateway;

import java.io.IOException;

/**
 * An interactor for determining whether the given login information is valid
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class LoginInteractor implements LoginInputBoundary {
    private final UserDataStoreGateway storage;
    public LoginInteractor(UserDataStoreGateway dataStorage) {
        this.storage = dataStorage;
    }

    /**
     * Attempts to login the given user, based on the request
     * @param request the login request information
     * @throws LoginException thrown when the login fails
     */
    public void login(LoginRequest request) throws LoginException {
        User loggedInUser;
        // catch empty request
        if (request.getUsername().equals("")) {
            throw new LoginException("");
        }
        // attempt login
        try {
            loggedInUser = storage.loadUser(request.getUsername(), request.getPassword());
        } catch (IOException error) {
            throw new LoginException("Invalid username or password.");
        } catch (DataStorageMalfunction error) {
            throw new LoginException("Fatal Error: " + error.getMessage());
        }

        InMemoryUser.setActiveUser(loggedInUser);
    }
}
