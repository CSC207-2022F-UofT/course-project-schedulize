package entity_factories;

import entity_layer.CommonUser;
import entity_layer.User;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String username, String email, String password) {
        return new CommonUser(username, email, password);
    }
}
