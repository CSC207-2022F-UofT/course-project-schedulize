package use_cases.user_registration;

import entity_layer.User;

import java.io.IOException;

public interface UserDataStoreGateway {
    boolean usernameExists(String username);
    void saveUser(User newUser) throws IOException;
}
