package use_cases.suggest_password;

/**
 * An Interface for interacting with the password suggestion Interactor(s)
 * Created: 11/25/2022
 * Last updated: 11/26/2022
 *
 * @author David Adler
 */
public interface PasswordSuggestionInputBoundary {
    /**
     * Retrieves a new password suggestion
     *
     * @return a password suggestion
     */
    String getNewSuggestion();
}
