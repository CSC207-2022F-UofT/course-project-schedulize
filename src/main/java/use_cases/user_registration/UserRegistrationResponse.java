package use_cases.user_registration;

/**
 * A response to a new user request, containing new user information
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationResponse {
    private final String newUsername;
    private final String password;

    /**
     * Constructor for the response
     * @param newUsername username of new user
     * @param password password of new user
     */
    public UserRegistrationResponse(String newUsername, String password) {
        this.newUsername = newUsername;
        this.password = password;
    }

    /**
     * @return username of the new user
     */
    public String getUsername() {
        return newUsername;
    }

    /**
     * @return password of the new user
     */
    public String password() {
        return this.password;
    }
}
