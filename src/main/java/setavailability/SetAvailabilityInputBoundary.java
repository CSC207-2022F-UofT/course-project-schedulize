package setavailability;

/**
 * Interface for the controller to interact with the SetAvailabilityTaskInteractor class
 *
 * @author od-obas1187
 */
public interface SetAvailabilityInputBoundary {

    /**
     * Creates a TimeManager, one that contains one TimeBlock for each availability/LocalTime
     *
     * @param availabilityInputs a String list of availabilities
     */
    void create(String[] availabilityInputs, int curriculumId);

}
