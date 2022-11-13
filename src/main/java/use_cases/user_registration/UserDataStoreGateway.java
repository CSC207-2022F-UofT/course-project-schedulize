package use_cases.user_registration;

import entity_layer.User;

public interface UserDataStoreGateway {
    boolean usernameExists(String username);
    void saveNewUser(User newUser);
}
