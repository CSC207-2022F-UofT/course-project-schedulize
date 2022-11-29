package use_cases.display_availability_timeblocks;
import entity_layer.*;


import java.time.LocalTime;
import java.util.List;

public class DisplayAvailabilityTimeBlockInteractor implements DisplayAvailabilityTimeBlockInputBoundary {
    private final DisplayAvailabilityTimeBlockOutputBoundary presenter;

    public DisplayAvailabilityTimeBlockInteractor(DisplayAvailabilityTimeBlockOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public DisplayAvailabilityTimeBlockModel displayAvailabilityTimeBlock() {
        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        TimeBlockManager timeBlockManager = schedule.getAvailability();
//        for (TimeBlock timeBlock: TimeBlockManager){
        return null;

        }
    }

