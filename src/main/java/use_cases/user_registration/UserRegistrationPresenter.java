package use_cases.user_registration;

import java.util.InvalidPropertiesFormatException;

public interface UserRegistrationPresenter {
    UserRegistrationResponse prepareSuccessView();
    void prepareFailView(String error);
}
