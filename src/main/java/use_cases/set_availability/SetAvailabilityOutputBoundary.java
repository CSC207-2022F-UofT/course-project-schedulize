package use_cases.set_availability;

/**
 * An OutputBoundary interface that is implemented by the presenter class,
 * for the interactor (implemented by InputBoundary) to interact with the presenter class
 *
 * @author od-obas1187
 */
public interface SetAvailabilityOutputBoundary {

    void availabilitiesSet(String message);

    void addViewObserver(SetAvailabilityViewInterface view);
}
