package use_cases.user_registration;

public interface UserRegistrationInputBoundary {
    UserRegistrationResponse create(UserRegistrationRequest newUserRequest) throws UserRegistrationError;
    int MINIMUM_PASSWORD_LENGTH = 8;
}
