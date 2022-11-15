package UI;

import use_cases.user_registration.UserRegistrationInputBoundary;
import use_cases.user_registration.UserRegistrationRequest;
import use_cases.user_registration.UserRegistrationResponse;

/**
 * A controller for registering a new user
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationController {
    private final UserRegistrationInputBoundary userInput;

    public UserRegistrationController(UserRegistrationInputBoundary interactor) {
        userInput = interactor;
    }

    public UserRegistrationResponse create(String email, String username, String password1, String password2) {
        UserRegistrationRequest input = new UserRegistrationRequest(email, username, password1, password2);
        return userInput.create(input);
    }
}
