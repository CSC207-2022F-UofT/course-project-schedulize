package use_cases.display_availability_timeblocks;

public class DisplayAvailabilityTimeBlockPresenter implements DisplayAvailabilityTimeBlockOutputBoundary {

    @Override
    public String availabilityTimeBlockDisplayed(DisplayAvailabilityTimeBlockModel displayedAvailabilityTimeBlock) {
        return displayedAvailabilityTimeBlock.toString();
    }

//    public String timeBlockDisplayed(DisplayAvailabilityTimeBlockModel displayedTimeBlock) {
////        return "Start Time " + displayedTimeBlock.getStartTime() + '\n' + "End Time " + displayedTimeBlock.getEndTime();
//
//    }
}
