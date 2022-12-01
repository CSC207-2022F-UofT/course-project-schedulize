import entity_layer.PasswordSuggester;
import entity_layer.RandomPasswordGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.suggest_password.PasswordSuggestionController;
import use_cases.suggest_password.PasswordSuggestionInputBoundary;
import use_cases.suggest_password.PasswordSuggestionInteractor;

import static entity_layer.PasswordSuggester.MIN_PASSWORD_LEN;

public class SuggestPasswordUseCaseTests {

    public static PasswordSuggestionController suggestionController;

    @BeforeAll
    public static void setUp() {
        PasswordSuggester suggester = new RandomPasswordGenerator();
        PasswordSuggestionInputBoundary suggestionInteractor = new PasswordSuggestionInteractor(suggester);
        suggestionController = new PasswordSuggestionController(suggestionInteractor);
    }

    @Test
    public void testPasswordLength() {
        String randomPassword = suggestionController.suggestNewPassword();
        assert randomPassword.length() >= MIN_PASSWORD_LEN;
    }

    @Test
    public void testUniquePasswordGeneration() {
        String[] passwords = new String[30];
        for (int i = 0; i < passwords.length; i++) {
            passwords[i] = suggestionController.suggestNewPassword();
        }

        for (int i = 1; i < passwords.length; i++) {
            if (!passwords[i].equals(passwords[i - 1]))
                return;
        }
        throw new AssertionError("All random passwords are the same");
    }
}
