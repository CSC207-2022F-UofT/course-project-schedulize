package use_cases.user_registration;

public class UserRegistrationResponseFormatter implements UserRegistrationPresenter {

    @Override
    public UserRegistrationResponse prepareSuccessView(String username) {
        return new UserRegistrationResponse(username);
    }
}
