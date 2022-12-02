package use_cases.set_availability;

public interface SetAvailabilityViewInterface {

    /**
     * Updates the view to notify user that availabilies were set
     *
     * @param message success message
     */
    void successfullySet(String message);
}
