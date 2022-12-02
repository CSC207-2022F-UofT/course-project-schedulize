package use_cases.set_availability;

/**
 * Interface for the controller to interact with the SetAvailabilityTaskInteractor class
 *
 * @author od-obas1187
 */
public interface SetAvailabilityInputBoundary {

    /**
     * Creates TimeBlocks based on User's inputted availabilities, updates the User's TimeBlockManager
     * to contain all of them
     *
     * @param availabilityInputs a String list of availabilities
     */
    void create(String[] availabilityInputs);

}
