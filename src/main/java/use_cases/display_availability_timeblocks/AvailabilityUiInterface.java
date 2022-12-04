package use_cases.display_availability_timeblocks;

import java.util.List;

/**
 * An interface for the DisplayAvailabilityTimeBlockPresenter to return information to the View
 */
public interface AvailabilityUiInterface {
    /**
     * Draws the availabilities passed through the model onto the UI
     *
     * @param availability the availability model
     */
    void drawAvailabilities(List<DisplayAvailabilityTimeBlockModel> availability);
}
