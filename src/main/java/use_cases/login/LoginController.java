package use_cases.login;

/**
 * A controller for logging in the user with the given name and password
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class LoginController {
    private final LoginInputBoundary loginRequester;

    /**
     * Default constructor
     * @param loginRequester interactor for this controller
     */
    public LoginController(LoginInputBoundary loginRequester) {
        this.loginRequester = loginRequester;
    }

    /**
     * Attempts to use the interactor to login the requested user
     * @param username username of requested user
     * @param password password of requested user
     * @throws LoginException for when login failed
     */
    public void login(String username, String password) throws LoginException {
        loginRequester.login(new LoginRequest(username, password));
    }
}
