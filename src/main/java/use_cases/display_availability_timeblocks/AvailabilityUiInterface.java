package use_cases.display_availability_timeblocks;

import java.util.List;

public interface AvailabilityUiInterface {
    /**
     * Draws the availabilities passed through the model onto the UI
     *
     * @param availability the availability model
     */
    void drawAvailabilities(List<DisplayAvailabilityTimeBlockModel> availability);
}
