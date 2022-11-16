package use_cases.login;

import config.DataStorageMalfunction;

public class LoginController {
    private final LoginInputBoundary loginRequester;

    public LoginController(LoginInputBoundary loginRequester) {
        this.loginRequester = loginRequester;
    }
    public void login(String username, String password) throws LoginException {
        loginRequester.login(new LoginRequest(username, password));
    }
}
