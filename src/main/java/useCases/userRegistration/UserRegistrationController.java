package useCases.userRegistration;

public class UserRegistrationController {
    private final UserRegistrationInputBoundary userInput;

    public UserRegistrationController(UserRegistrationInputBoundary interactor) {
        userInput = interactor;
    }

    public UserRegistrationResponse create(String email, String username, String password1, String password2) {
        UserRegistrationRequest input = new UserRegistrationRequest(email, username, password1, password2);
        return null;
    }
}
