package use_cases.set_availability;

/**
 * An OutputBoundary interface that is implemented by the presenter class,
 * for the interactor (implemented by InputBoundary) to interact with the presenter class
 *
 * @author od-obas1187
 */
public interface SetAvailabilityOutputBoundary {

    /**
     * Confirms that the availabilities were set with a confirmation message.
     *
     * @param message a message confirming the task was completed.
     */
    void availabilitiesSet(String message);

    /**
     * Adds the view interface provided in the parameter to this class's list of view interfaces.
     *
     * @param view A view interface
     */
    void addViewObserver(SetAvailabilityViewInterface view);
}
