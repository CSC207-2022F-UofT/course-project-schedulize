package use_cases.login;

/**
 * Exception for when a login fails
 * Created: 11/15/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class LoginException extends RuntimeException {
    public LoginException(String msg) {
        super(msg);
    }
}
