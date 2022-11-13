package entity_layer;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String username, String email, String password) {
        return new CommonUser(username, email, password);
    }
}
