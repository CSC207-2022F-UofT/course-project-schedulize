package entity_layer;

public interface UserFactory {
    User create(String username, String email, String password);
}
