package use_cases.set_availability;

/**
 * Controller class responsible for initializing the first-time setting of availability;
 * through create function, takes input of set of availabilities (type String) & gives it
 * to SetAvailability interactor.
 *
 * @author od-obas1187
 */
public class SetAvailabilityController {
    private final SetAvailabilityInputBoundary userAvailabilityInteractor;

    /**
     * Receives interactor (implemented by InputBoundary, interactor ar runtime) & Sets
     * controller's interactor (same implementation) to the interactor given by parameter
     *
     * @param interactor Interactor given to controller to create TimeBlockFactory, which creates
     *                   TimeBlockManager & corresponding TimeBlocks
     */
    public SetAvailabilityController(SetAvailabilityInputBoundary interactor) {

        this.userAvailabilityInteractor = interactor;

    }

    /**
     * 1. Receives set of String values (user’s availabilities) & curriculumID;
     * 2. Sends them to the SetAvailabilityInteractor
     *
     * @param availabilities a String list of availabilities
     */
    public void create(String[] availabilities) {

        userAvailabilityInteractor.create(availabilities);

    }
}
