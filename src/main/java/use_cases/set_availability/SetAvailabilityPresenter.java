package use_cases.set_availability;

/**
 * ...
 *
 * @author od-obas1187
 */
public class SetAvailabilityPresenter implements SetAvailabilityOutputBoundary{

    /**
     * Confirm that the availabilities were set.
     *
     * @param availabilityModel model containing completed task information.
     * @return a message confirming the task was completed.
     */
    @Override
    public String availabilitiesSet(SetAvailabilityModel availabilityModel) {
        return "The availabilities from " + availabilityModel.getCurriculumName()
                + " were set properly.";
    }
}
