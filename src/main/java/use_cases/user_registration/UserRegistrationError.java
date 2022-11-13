package use_cases.user_registration;

public class UserRegistrationError extends RuntimeException {

    public UserRegistrationError(String error) {
        super(error);
    }
}
