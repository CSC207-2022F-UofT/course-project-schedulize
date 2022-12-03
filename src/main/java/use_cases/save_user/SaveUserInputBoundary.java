package use_cases.save_user;

/**
 * An interface for interacting with the SaveUserInteractor
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public interface SaveUserInputBoundary {

    /**
     * Saves the user loaded into memory
     */
    void saveInMemoryUser();
}
