package use_cases.login;

public class LoginController {
    private final LoginInputBoundary loginRequester;

    public LoginController(LoginInputBoundary loginRequester) {
        this.loginRequester = loginRequester;
    }
    public void login(String username, String password) {
        loginRequester.login(new LoginRequest(username, password));
    }
}
