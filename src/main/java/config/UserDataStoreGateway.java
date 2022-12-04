package config;

import entity_layer.User;

import java.io.IOException;

/**
 * An interface for interacting with the data storage
 * Created: 11/13/2022
 * Last updated: 11/14/2022
 *
 * @author David Adler
 */
public interface UserDataStoreGateway {
    boolean usernameExists(String username);
    void saveUser(User newUser) throws IOException;
    User loadUser(String username, String password) throws DataStorageMalfunction, IOException;
}
