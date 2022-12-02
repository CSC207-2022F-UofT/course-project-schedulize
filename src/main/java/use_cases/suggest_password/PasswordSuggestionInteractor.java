package use_cases.suggest_password;

import entity_layer.PasswordSuggester;

/**
 * An Interactor that generates random passwords
 * Created: 11/25/2022
 * Last updated: 11/26/2022
 *
 * @author David Adler
 */
public class PasswordSuggestionInteractor implements PasswordSuggestionInputBoundary {
    private final PasswordSuggester suggester;

    /**
     * Constructor
     * @param suggester the password generator that this interactor uses to generate passwords
     */
    public PasswordSuggestionInteractor(PasswordSuggester suggester) {
        this.suggester = suggester;
    }

    /**
     * Generates a new password
     * @return new password suggestion
     */
    @Override
    public String getNewSuggestion() {
        return suggester.suggestPassword();
    }
}
