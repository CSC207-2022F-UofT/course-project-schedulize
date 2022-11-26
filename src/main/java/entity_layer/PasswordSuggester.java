package entity_layer;

public interface PasswordSuggester {
    String suggestPassword();
    int MIN_PASSWORD_LEN = 10;
}
