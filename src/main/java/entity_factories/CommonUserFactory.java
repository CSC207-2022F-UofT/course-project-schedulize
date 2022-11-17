package entity_factories;

import entity_factories.CommonUser;
import entity_layer.User;
import entity_layer.UserFactory;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String username, String email, String password) {
        return new CommonUser(username, email, password);
    }
}
