package use_cases.user_registration;

/**
 * A request to register a new User
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationRequest {
    private final String email;
    private final String username;
    private final String password1;
    private final String password2;

    /**
     * Constructor for this registry request
     * @param email new user's email
     * @param username new user's username
     * @param password1 new user's password
     * @param password2 new user's password confirmation
     */
    public UserRegistrationRequest(String email, String username, String password1, String password2) {
        this.email = email;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    /**
     * @return this request's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return this request's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return this request's password
     */
    public String getPassword() {
        return this.password1;
    }

    /**
     * Determine whether  the password repeat is valid
     * @return boolean, true if passwords match, false otherwise
     */
    public boolean isValidPasswordRepeat() {
        return this.password1.equals(this.password2);
    }

    /**
     * Determines if Email has a valid structure
     * @return boolean, true if email has valid structure, false otherwise
     */
    public boolean isValidEmail() {
        int atSignIndex = this.email.indexOf("@");

        if (atSignIndex == -1) {
            return false;
        }

        int extensionIndex = this.email.indexOf(".", atSignIndex);

        return extensionIndex != -1;
    }
}
