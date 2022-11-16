package setavailability;

/**
 * Class responsible for initializing the first-time setting of availability;
 * takes input of set of LocalTime values & gives it to SetAvailability interactor.
 *
 * @author: od-obas1187
 */
public class SetAvailabilityController {
    public static SetAvailabilityInputBoundary userAvailabilityInput;

    /**
     * 1. Receives set of String values (user’s availabilities);
     * 2. Sets the availabilities inputted by the user, sends it to the
     * SetAvailabilityInputBoundary
     *
     * @param availabilityInputs
     */
    public SetAvailabilityController(String[] availabilityInputs) {

        userAvailabilityInput.create(availabilityInputs);
    }
}
