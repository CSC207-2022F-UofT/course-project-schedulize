package use_cases.suggest_password;

import entity_layer.PasswordSuggester;

public class PasswordSuggestionInteractor implements PasswordSuggestionInputBoundary {
    private final PasswordSuggester suggester;

    public PasswordSuggestionInteractor(PasswordSuggester suggester) {
        this.suggester = suggester;
    }

    @Override
    public String getNewSuggestion() {
        return suggester.suggestPassword();
    }
}
