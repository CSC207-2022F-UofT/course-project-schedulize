package use_cases.display_availability_timeblocks;

import java.util.List;

/**
 * An output boundary interface that is implemented by the DisplayTimeBlockPresenter class.
 * Created: 11/22/2022
 * Last updated: 11/22/2022
 *
 * @author amira
 */
public interface DisplayAvailabilityTimeBlockOutputBoundary {
    /**
     * Prepares the passed models for presentation to the view
     *
     * @param availabilityTimeBlockModels The models representing availability time blocks
     */
    void availabilityTimeBlockDisplayed(List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockModels);

    /**
     * Adds a view to observe this output boundary
     *
     * @param view The view to be added
     */
    void addAvailabilityObserver(AvailabilityUiInterface view);
}
