package UI;

import use_cases.user_registration.UserRegistrationInputBoundary;
import use_cases.user_registration.UserRegistrationRequest;
import use_cases.user_registration.UserRegistrationResponse;

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
