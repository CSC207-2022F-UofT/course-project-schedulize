package use_cases.display_availability_timeblocks;

/**
 * A model class for packaging the required info needed by the DisplayAvailabilityTimeBlockModel.
 * Created: 11/28/2022
 * Last updated: 12/01/2022
 *
 * @author Amir Bare; amira
 */
public class DisplayAvailabilityTimeBlockModel {

    private final String startTime;
    private final String endTime;

    /**
     * Default constructor
     * @param startTime for this model
     * @param endTime for this model
     */
    public DisplayAvailabilityTimeBlockModel(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Get the start time when the user is available.
     *
     * @return the start time when the user is available
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Get the time when the user's availability ends.
     *
     * @return the time when the user's availability ends
     */
    public String getEndTime() {
        return endTime;
    }

}
