package use_cases.save_user;

/**
 * A controller class for saving the loaded User throughout the program's lifetime
 * Created: 12/01/2022
 * Last updated: 12/01/2022
 *
 * @author David Adler
 */
public class SaveUserController {
    private final SaveUserInputBoundary interactor;

    /**
     * Constructor for this controller that sets its interactor
     * @param interactor the interactor for saving the in memory user
     */
    public SaveUserController(SaveUserInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Saves the user that has been loaded into memory if there is one
     */
    public void saveInMemoryUser() {
        interactor.saveInMemoryUser();
    }
}
