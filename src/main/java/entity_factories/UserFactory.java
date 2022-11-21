package entity_factories;

import entity_layer.User;

public interface UserFactory {
    User create(String username, String email, String password);
}
