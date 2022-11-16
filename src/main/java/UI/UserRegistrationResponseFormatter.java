package UI;

import use_cases.user_registration.UserRegistrationPresenter;
import use_cases.user_registration.UserRegistrationResponse;

/**
 * A presenter that returns data after a new user has been registered
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationResponseFormatter implements UserRegistrationPresenter {

    @Override
    public UserRegistrationResponse prepareSuccessView(String username, String password) {
        return new UserRegistrationResponse(username, password);
    }
}
