package entity_layer;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.IntStream;

/**
 * A class that can generate a random password String
 * Created: 11/24/2022
 * Last updated: 11/26/2022
 *
 * @author David Adler
 */
public class RandomPasswordGenerator implements PasswordSuggester {
    private StringBuilder suggestion;
    private final SecureRandom randomizer;
    private int numCharsToAdd;

    /**
     * Default constructor that initializes the secure randomizer for the generator
     */
    public RandomPasswordGenerator() {
        this.randomizer = new SecureRandom();
    }

    /**
     * Create new random password
     * @return random password String
     */
    @Override
    public String suggestPassword() {
        this.setSuggestion();
        return new String(this.suggestion);
    }

    /**
     * Sets the suggestion field of this class to a new random password
     */
    private void setSuggestion() {
        this.setSuggestionLength();
        this.suggestion = new StringBuilder();
        this.suggestion.append(this.getCapitalCharacters());
        this.suggestion.append(this.getSpecialCharacters());
        this.suggestion.append(this.getNumberCharacters());
        this.suggestion.append(this.getNormalCharacters());
        this.suggestion = shuffleChars(this.suggestion);
    }

    /**
     * randomly decides the length of a new password
     */
    private void setSuggestionLength() {
        int MAX_PASSWORD_LEN = 13;
        this.numCharsToAdd = this.getRandomInt(MIN_PASSWORD_LEN, MAX_PASSWORD_LEN + 1);
    }

    /**
     * Gets the capital letters to put in the new random password
     * @return a random number of capital letters in a char array
     */
    private char[] getCapitalCharacters() {
        int numCapitals = this.getRandomInt(1, this.getUpperBound());
        this.numCharsToAdd -= numCapitals;

        return this.getRandomizedChars(numCapitals, 65, 91);
    }

    /**
     * Gets the special characters to put in the new random password
     * @return a random number of special characters in a char array
     */
    private char[] getSpecialCharacters() {
        int numSpecial = this.getRandomInt(1, this.getUpperBound());
        this.numCharsToAdd -= numSpecial;

        return this.getRandomizedChars(numSpecial, 33, 48);
    }

    /**
     * Gets the number characters to put in the new random password
     * @return a random number of number characters in a char array
     */
    private char[] getNumberCharacters() {
        int numberChars = this.getRandomInt(1, this.getUpperBound());
        this.numCharsToAdd -= numberChars;

        return this.getRandomizedChars(numberChars, 48, 58);
    }

    /**
     * Gets the maximum number of the random int to select + 1, since the upperBound of the getRandomInt function is
     * non-inclusive
     * @return an integer representing the maximum number of characters that can be selected + 1
     */
    private int getUpperBound() {
        int IRREGULAR_CHAR_PROPORTION = 3;
        return Math.max(2, this.numCharsToAdd / IRREGULAR_CHAR_PROPORTION);
    }

    /**
     * Gets the number of regular letter characters to add to this password, using the remaining number of characters
     * to obtain the requested length
     * @return lower case letters in a char array
     */
    private char[] getNormalCharacters() {
        return this.getRandomizedChars(this.numCharsToAdd, 97, 123);
    }

    /**
     * Gets a random int using an IntStream that is greater than or equal to lowerBound and less than upperBound
     * If the bounds are invalid, the lowerBound is returned
     * @param lowerBound the lowest possible int returned
     * @param upperBound the highest possible int returned + 1
     * @return a random int between lower and upper bound values
     */
    private int getRandomInt(int lowerBound, int upperBound) {
        if (lowerBound < upperBound) {
            IntStream options = randomizer.ints(lowerBound, upperBound);
            return options.limit(1).toArray()[0];
        } else {
            return lowerBound;
        }
    }

    /**
     * Gets numRequested number of random characters with ASCII values between the upper and lower bounds
     * @param numRequested number of characters to return
     * @param lowerBound the lowest ASCII value of the characters generated
     * @param upperBound the highest possible ASCII value of the characters generated + 1
     * @return a char array of length numRequested, where all ASCII values of chars are between lower and upper bound
     */
    private char[] getRandomizedChars(int numRequested, int lowerBound, int upperBound) {
        IntStream lengthOptions = randomizer.ints(lowerBound, upperBound);
        int [] chosenInts = lengthOptions.limit(numRequested).toArray();
        char[] chosenChars = new char[numRequested];

        for (int i = 0; i < numRequested; i++) {
            chosenChars[i] = (char) chosenInts[i];
        }

        return chosenChars;
    }

    /**
     * Shuffles the characters in a StringBuilder, and returns a new StringBuilder with the characters shuffled
     * @param original the StringBuilder with characters to shuffle
     * @return a new StringBuilder with the same characters as the original but in a different random order
     */
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
}
