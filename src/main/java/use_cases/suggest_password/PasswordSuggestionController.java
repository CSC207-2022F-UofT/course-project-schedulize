package use_cases.suggest_password;

public class PasswordSuggestionController {

    private final PasswordSuggestionInputBoundary suggestionInteractor;

    public PasswordSuggestionController(PasswordSuggestionInputBoundary suggestionInteractor) {
        this.suggestionInteractor = suggestionInteractor;
    }

    public String suggestNewPassword() {
        return this.suggestionInteractor.getNewSuggestion();
    }
}
