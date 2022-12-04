package entity_factories;

import entity_layer.User;

/**
 * An abstract factory to create objects that implement the User interface.
 */
public interface UserFactory {
    /**
     * Creates an object of type User
     *
     * @param username The User's username
     * @param email The User's email
     * @param password The User's password
     * @return A new object of type User
     */
    User create(String username, String email, String password);
}
