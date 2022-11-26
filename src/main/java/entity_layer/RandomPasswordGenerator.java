package entity_layer;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.IntStream;

public class RandomPasswordGenerator implements PasswordSuggester {
    private StringBuilder suggestion;
    private final SecureRandom randomizer;
    private int numCharsToAdd;
    private final int IRREGULAR_CHAR_PROPORTION = 3;

    public RandomPasswordGenerator() {
        this.randomizer = new SecureRandom();
    }

    @Override
    public String suggestPassword() {
        this.setSuggestion();
        return new String(this.suggestion);
    }

    private void setSuggestion() {
        this.setSuggestionLength();
        this.suggestion = new StringBuilder();
        this.suggestion.append(this.getCapitalCharacters());
        this.suggestion.append(this.getSpecialCharacters());
        this.suggestion.append(this.getNumberCharacters());
        this.suggestion.append(this.getNormalCharacters());
        this.suggestion = shuffleChars(this.suggestion);
    }

    private void setSuggestionLength() {
        int MIN_PASSWORD_LEN = 10;
        int MAX_PASSWORD_LEN = 13;
        this.numCharsToAdd = this.getRandomInt(MIN_PASSWORD_LEN, MAX_PASSWORD_LEN + 1);
    }

    private char[] getCapitalCharacters() {
        int numCapitals = this.getRandomInt(1, this.numCharsToAdd / this.IRREGULAR_CHAR_PROPORTION);
        this.numCharsToAdd -= numCapitals;

        return this.getRandomizedChars(numCapitals, 65, 91);
    }

    private char[] getSpecialCharacters() {
        int numSpecial = this.getRandomInt(1, this.numCharsToAdd / this.IRREGULAR_CHAR_PROPORTION);
        this.numCharsToAdd -= numSpecial;

        return this.getRandomizedChars(numSpecial, 33, 48);
    }

    private char[] getNumberCharacters() {
        int numberChars = this.getRandomInt(1, this.numCharsToAdd / this.IRREGULAR_CHAR_PROPORTION);
        this.numCharsToAdd -= numberChars;

        return this.getRandomizedChars(numberChars, 48, 58);
    }

    private char[] getNormalCharacters() {
        return this.getRandomizedChars(this.numCharsToAdd, 97, 123);
    }

    private int getRandomInt(int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            IntStream options = randomizer.ints(lowerBound, upperBound);
            return options.limit(1).toArray()[0];
        } else {
            return lowerBound;
        }
    }

    private char[] getRandomizedChars(int numRequested, int lowerBound, int upperBound) {
        IntStream lengthOptions = randomizer.ints(lowerBound, upperBound);
        int [] chosenInts = lengthOptions.limit(numRequested).toArray();
        char[] chosenChars = new char[numRequested];

        for (int i = 0; i < numRequested; i++) {
            chosenChars[i] = (char) chosenInts[i];
        }

        return chosenChars;
    }

    private static StringBuilder shuffleChars(StringBuilder original) {
        char[] toShuffle = original.toString().toCharArray();
        List<Character> chars = new ArrayList<>();
        for (char c : toShuffle)
            chars.add(c);
        Collections.shuffle(chars);
        for (int i = 0; i < toShuffle.length; i++)
            toShuffle[i] = chars.get(i);

        return new StringBuilder(String.valueOf(toShuffle));
    }

    public static void main(String[] args) {
        RandomPasswordGenerator suggester = new RandomPasswordGenerator();
        for (int i = 0; i < 100; i ++) {
            System.out.println(suggester.suggestPassword());
        }
    }
}
