package entity_layer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.Character.*;

public class RandomPasswordGeneratorTests {
    public static PasswordSuggester suggester;

    @BeforeAll
    public static void setUp() {
        suggester = new RandomPasswordGenerator();
    }

    @Test
    public void testPasswordFormat() {
        String randomPassword = suggester.suggestPassword();
        testPasswordCharacterMakeUp(randomPassword);
    }

    public static void testPasswordCharacterMakeUp(String randomPassword) {
        char[] passwordChars = randomPassword.toCharArray();

        int numSpecial = 0;
        int numUpperCase = 0;
        int numNumbers = 0;
        for (char c: passwordChars) {
            if (isUpperCase(c)) {
                numUpperCase++;
            } else if (isDigit(c)) {
                numNumbers++;
            } else if (!isLetter(c)) {
                numSpecial++;
            }
        }
        assert numSpecial >= 1;
        assert numUpperCase >= 1;
        assert numNumbers >= 1;
        assert passwordChars.length >= 8;
    }
}
