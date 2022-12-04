package use_cases.display_availability_timeblocks;
import entity_layer.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Interactor containing a use case that displays a user's availability.
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author amira
 */

public class DisplayAvailabilityTimeBlockInteractor implements DisplayAvailabilityTimeBlockInputBoundary {
    private final DisplayAvailabilityTimeBlockOutputBoundary presenter;

    public DisplayAvailabilityTimeBlockInteractor(DisplayAvailabilityTimeBlockOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Display the user's availability by looping through timeblocks and adding start and endtimes to a list.
     * Calling the presenter and passing the list as an argument.
     */
    @Override
    public void displayAvailabilityTimeBlock() {
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();
        String startTimeString;
        String endTimeString;
        List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockModel = new ArrayList<>();
        for (TimeBlock t : timeBlockManager) {
            startTimeString = Integer.toString(t.getStartTime().getHour()) + ':' +
                    (t.getStartTime().getMinute());
            endTimeString = Integer.toString(t.getEndTime().getHour()) + ':' +
                    (t.getEndTime().getMinute());
            availabilityTimeBlockModel.add(new DisplayAvailabilityTimeBlockModel(startTimeString, endTimeString));
        }
        presenter.availabilityTimeBlockDisplayed(availabilityTimeBlockModel);
    }
}

