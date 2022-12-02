package use_cases.suggest_password;

/**
 * A controller for suggesting a new random password
 * Created: 11/25/2022
 * Last updated: 11/26/2022
 *
 * @author David Adler
 */
public class PasswordSuggestionController {

    private final PasswordSuggestionInputBoundary suggestionInteractor;

    /**
     * Constructor
     * @param suggestionInteractor the inputBoundary that this controller uses to generate passwords
     */
    public PasswordSuggestionController(PasswordSuggestionInputBoundary suggestionInteractor) {
        this.suggestionInteractor = suggestionInteractor;
    }

    /**
     * gets a password suggestion for the UI
     * @return a new password
     */
    public String suggestNewPassword() {
        return this.suggestionInteractor.getNewSuggestion();
    }
}
