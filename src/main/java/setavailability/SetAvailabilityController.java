package setavailability;

/**
 * Class responsible for initializing the first-time setting of availability;
 * takes input of set of LocalTime values & gives it to SetAvailability interactor.
 *
 * @author od-obas1187
 */
public class SetAvailabilityController {
    SetAvailabilityUseCase userAvailabilityInteractor;

    /**
     * 1. Receives interactor
     * 2. Sets controller's interactor to the interactor given from parameter
     *
     * @param interactor Interactor given to controller to create TimeBlockFactory, which creates TimeBlockManager
     *                   & corresponding TimeBlocks
     */
    public SetAvailabilityController(SetAvailabilityUseCase interactor) {

        this.userAvailabilityInteractor = interactor;

    }

    /**
     * 1. Receives set of String values (user’s availabilities);
     * 2. Sends them to the SetAvailabilityInteractor
     */
    public void create(String[] availabilities, int curriculumId) {

        userAvailabilityInteractor.create(availabilities, curriculumId);

    }
}
