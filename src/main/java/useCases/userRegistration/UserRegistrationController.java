package useCases.userRegistration;

public class UserRegistrationController {
    private final UserRegistrationInputBoundary userInput;

    public UserRegistrationController(UserRegistrationInputBoundary interactor) {
        userInput = interactor;
    }
}
