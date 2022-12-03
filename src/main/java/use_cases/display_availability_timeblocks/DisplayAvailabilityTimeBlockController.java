package use_cases.display_availability_timeblocks;

/**
 * A controller for viewing the availability of a user
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Amir Bare; amira
 */
public class DisplayAvailabilityTimeBlockController {
    private final DisplayAvailabilityTimeBlockInputBoundary displayAvailabilityTimeBlockInteractor;

    /**
     * Default constructor
     * @param interactor for this controller.
     */
    public DisplayAvailabilityTimeBlockController(DisplayAvailabilityTimeBlockInteractor interactor) {
        this.displayAvailabilityTimeBlockInteractor = interactor;
    }

    /**
     * Calling the method that will be overridden in the interactor.
     *
     */
    public void displayAvailabilityTimeBlock(){
        displayAvailabilityTimeBlockInteractor.displayAvailabilityTimeBlock();
    }
}

