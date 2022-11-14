package UI;

import use_cases.user_registration.UserRegistrationPresenter;
import use_cases.user_registration.UserRegistrationResponse;

public class UserRegistrationResponseFormatter implements UserRegistrationPresenter {

    @Override
    public UserRegistrationResponse prepareSuccessView(String username) {
        return new UserRegistrationResponse(username);
    }
}
