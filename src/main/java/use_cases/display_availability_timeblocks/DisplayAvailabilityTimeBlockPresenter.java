package use_cases.display_availability_timeblocks;
import java.util.List;

/**
 * Presenter for the UI that displays the user's availability.
 * Created: 11/29/2022
 * Last updated: 12/01/2022
 *
 * @author amira
 */

public class DisplayAvailabilityTimeBlockPresenter implements DisplayAvailabilityTimeBlockOutputBoundary {

    /**
     * Display a message that the task was completed.
     *
     * @param availabilityTimeBlockModels model containing display availability time block info.
     * @return a list of start times and end times of a user's availability.
     */
    @Override
    public List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockDisplayed(List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockModels) {
        return availabilityTimeBlockModels;
    }
}

