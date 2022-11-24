package use_cases.display_availability_timeblocks;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DisplayAvailabilityTimeBlockController {
    private DisplayAvailabilityTimeBlockInputBoundary timeBlockDisplay;

    /**
     * Default constructor
     * @param timeBlockDisplay interactor for this controller
     */

    public DisplayAvailabilityTimeBlockController(DisplayAvailabilityTimeBlockInputBoundary timeBlockDisplay) {
        this.timeBlockDisplay = timeBlockDisplay;
    }

    public void displayTimeBlock(){
        timeBlockDisplay.displayAvailabilityTimeBlock();
    }

}
