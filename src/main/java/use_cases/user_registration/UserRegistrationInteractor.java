package use_cases.user_registration;

import entity_layer.User;
import entity_factories.UserFactory;

import java.io.IOException;

/**
 * The interactor that determines whether the new User information is valid and whether or not to save the user
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public class UserRegistrationInteractor implements UserRegistrationInputBoundary {
    private final UserFactory userFactory;
    private final UserDataStoreGateway existingUsers;
    private final UserRegistrationPresenter resultPresenter;

    public UserRegistrationInteractor(UserFactory userFactory, UserDataStoreGateway existingUsers,
                                      UserRegistrationPresenter resultPresenter) {
        this.userFactory = userFactory;
        this.existingUsers = existingUsers;
        this.resultPresenter = resultPresenter;
    }

    @Override
    public UserRegistrationResponse create(UserRegistrationRequest newUserRequest) throws UserRegistrationError {
        if (!newUserRequest.isValidPasswordRepeat()) {
            throw new UserRegistrationError("Password and Confirmation must match.");
        } else if (newUserRequest.getPassword().length() < MINIMUM_PASSWORD_LENGTH) {
            throw new UserRegistrationError("Password must be at least " + MINIMUM_PASSWORD_LENGTH +
                    " characters.");
        } else if (!newUserRequest.isValidEmail()) {
            throw new UserRegistrationError("Invalid email address.");
        } else if (existingUsers.usernameExists(newUserRequest.getUsername())) {
            throw new UserRegistrationError("Username already exists.");
        }

        User newUser = userFactory.create(newUserRequest.getUsername(), newUserRequest.getEmail(),
                                          newUserRequest.getPassword());
        try {
            existingUsers.saveUser(newUser);
        } catch (IOException except) {
            throw new UserRegistrationError("Data Saving Error");
        }

        return resultPresenter.prepareSuccessView(newUserRequest.getUsername(), newUserRequest.getPassword());
    }
}
