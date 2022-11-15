package use_cases.user_registration;

/**
 * An interface for formatting required information to the UI
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public interface UserRegistrationPresenter {
    UserRegistrationResponse prepareSuccessView(String username, String password);
}
