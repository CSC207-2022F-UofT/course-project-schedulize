package use_cases.display_availability_timeblocks;

import java.time.LocalTime;

public class DisplayAvailabilityTimeBlockModel {
    private final LocalTime[] startTime;
    private final LocalTime[] endTime;

    public DisplayAvailabilityTimeBlockModel(LocalTime[] startTime, LocalTime[] endTime) {

        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime[] getStartTime() {
        return startTime;
    }

    public LocalTime[] getEndTime() {
        return endTime;
    }
}
