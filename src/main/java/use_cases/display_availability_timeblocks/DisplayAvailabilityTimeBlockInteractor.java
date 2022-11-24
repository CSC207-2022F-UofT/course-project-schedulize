package use_cases.display_availability_timeblocks;
import entity_layer.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DisplayAvailabilityTimeBlockInteractor implements DisplayAvailabilityTimeBlockInputBoundary {
    private DisplayAvailabilityTimeBlockOutputBoundary presenter;

    public DisplayAvailabilityTimeBlockInteractor(DisplayAvailabilityTimeBlockOutputBoundary presenter) {
        this.presenter = presenter;
    }



    @Override
    public void displayAvailabilityTimeBlock() {
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        schedule.getAvailability();





//        Use In Memory user class to get active user's curriculum.





    }
}
