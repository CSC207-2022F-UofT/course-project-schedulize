package use_cases.set_availability;

/**
 * A view interface for working with the Display UI, implemented through the Display UI
 */
public interface SetAvailabilityViewInterface {

    /**
     * Updates the view to notify user that availabilities were set
     *
     * @param message success message
     */
    void successfullySet(String message);
}
