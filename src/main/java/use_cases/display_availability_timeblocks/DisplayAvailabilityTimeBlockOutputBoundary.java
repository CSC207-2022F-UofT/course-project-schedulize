package use_cases.display_availability_timeblocks;

import entity_layer.TimeBlock;

/**
 * An output boundary interface that is implemented by the DisplayTimeBlockPresenter class.
 *
 * Created: 11/22/2022
 * Last updated: 11/22/2022
 *
 * @author Amir Bare
 */

public interface DisplayAvailabilityTimeBlockOutputBoundary {
    String availabilityTimeBlockDisplayed(DisplayAvailabilityTimeBlockModel displayedAvailabilityTimeBlock);
}
