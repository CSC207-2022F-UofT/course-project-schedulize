package use_cases.set_availability;

/**
 * A view interface (to be tested) that stores the data from the presenter in order to be checked;
 * implements ViewInterface interface
 *
 * @author od-obas1187
 */
public class SetAvailabilityTestingViewInterface implements SetAvailabilityViewInterface {

    private String returnMessage;

    /**
     * Sets this class's return message to an empty String (to be replaced later in the Set Availability
     * algorithm)
     */
    public SetAvailabilityTestingViewInterface() {
        this.returnMessage = "";
    }

    /**
     * Updates the view to notify user that availabilities were set
     *
     * @param message success message
     */
    @Override
    public void successfullySet(String message) {
        this.returnMessage = message;
        System.out.println(message);
        System.out.println(this.returnMessage);
    }

    /**
     * Returns the message set in successfullySet
     *
     * @return The return message set in successfullySet
     */
    public String getReturnMessage() {
        return this.returnMessage;
    }

}
