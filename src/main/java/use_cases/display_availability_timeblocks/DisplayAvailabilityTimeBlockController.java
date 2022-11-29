package use_cases.display_availability_timeblocks;

import java.time.LocalTime;

public class DisplayAvailabilityTimeBlockController {
    private final DisplayAvailabilityTimeBlockInteractor displayAvailabilityTimeBlockInteractor;

    public DisplayAvailabilityTimeBlockController(DisplayAvailabilityTimeBlockInteractor interactor) {
        this.displayAvailabilityTimeBlockInteractor = interactor;
    }
    public void displayAvailabilityTimeBlock(){
        displayAvailabilityTimeBlockInteractor.displayAvailabilityTimeBlock();
    }
}

