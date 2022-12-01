package use_cases.display_availability_timeblocks;

import java.util.List;

/**
 * An output boundary interface that is implemented by the DisplayTimeBlockPresenter class.
 *
 * Created: 11/22/2022
 * Last updated: 11/22/2022
 *
 * @author amira
 */

public interface DisplayAvailabilityTimeBlockOutputBoundary {
    List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockDisplayed(List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockModels);
}
