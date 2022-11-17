package use_cases.user_registration;

/**
 * An interface for interacting with the UserRegistrationInteractor
 * Created: 11/13/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public interface UserRegistrationInputBoundary {
    void create(UserRegistrationRequest newUserRequest) throws UserRegistrationError;
    int MINIMUM_PASSWORD_LENGTH = 8;
}
