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
    void login(LoginRequest request) throws DataStorageMalfunction, LoginException;
}
