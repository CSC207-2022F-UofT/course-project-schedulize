package use_cases.login;

/**
 * The model for a login request
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class LoginRequest {
    private final String username;
    private final String password;

    /**
     * Constructs a LoginRequest model
     *
     * @param username the username provided
     * @param password the password provided
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
