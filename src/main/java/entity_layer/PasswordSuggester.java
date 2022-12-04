package entity_layer;

/**
 * An Interface for interacting with classes that can generate passwords
 * Created: 11/25/2022
 * Last updated: 11/26/2022
 *
 * @author David Adler
 */
public interface PasswordSuggester {
    /**
     * Returns a suggested password option.
     *
     * @return A possible password.
     */
    String suggestPassword();
    int MIN_PASSWORD_LEN = 10;
}
