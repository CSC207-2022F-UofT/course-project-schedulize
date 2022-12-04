package use_cases.login;

import config.DataStorageMalfunction;

/**
 * An interface for interacting with the loginInteractor
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public interface LoginInputBoundary {

    /**
     * Attempts to log in the given user, based on the request
     * @param request the login request information
     * @throws LoginException thrown when the login fails
     */
    void login(LoginRequest request) throws DataStorageMalfunction, LoginException;
}
