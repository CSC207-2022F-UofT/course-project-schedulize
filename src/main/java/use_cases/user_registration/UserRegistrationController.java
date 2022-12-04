package use_cases.user_registration;

/**
 * A controller for registering a new user
 * Created: 11/13/2022
 * Last updated: 11/15/2022
 *
 * @author David Adler
 */
public class UserRegistrationController {
    private final UserRegistrationInputBoundary userInput;

    /**
     * Constructs a UserRegistrationController
     *
     * @param interactor the input boundary this controller will use to access the entity layer
     */
    public UserRegistrationController(UserRegistrationInputBoundary interactor) {
        userInput = interactor;
    }

    /**
     * Initializes the creation of a new user
     *
     * @param email the proposed email of the new user
     * @param username the proposed username of the new user
     * @param password1 the proposed password of the new user
     * @param password2 the attempted repition of password1
     */
    public void create(String email, String username, String password1, String password2) {
        UserRegistrationRequest input = new UserRegistrationRequest(email, username, password1, password2);
        userInput.create(input);
    }
}
