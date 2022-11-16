package use_cases.login;

import config.DataStorageMalfunction;

public interface LoginInputBoundary {
    void login(LoginRequest request) throws DataStorageMalfunction, LoginException;
}
