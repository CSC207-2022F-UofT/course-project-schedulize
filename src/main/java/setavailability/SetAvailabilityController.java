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
     * 1. Receives set of String values (user’s availabilities);
     * 2. Sets the availabilities inputted by the user, sends it to the
     * SetAvailabilityInputBoundary
     *
     * @param interactor an interactor
     */
    public SetAvailabilityController(SetAvailabilityUseCase interactor) {

        this.userAvailabilityInteractor = interactor;

    }

    /**
     * Using controller's
     */
    public void create(String[] availabilities) {
       userAvailabilityInteractor.create(availabilities);
    }
}
