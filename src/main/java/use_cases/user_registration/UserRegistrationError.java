package use_cases.user_registration;

/**
 * An error for inability to register the requested new user
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationError extends RuntimeException {

    public UserRegistrationError(String error) {
        super(error);
    }
}
