package use_cases.display_availability_timeblocks;
import java.util.List;

/**
 * Presenter for the UI that displays the user's availability.
 * Created: 11/29/2022
 * Last updated: 12/01/2022
 *
 * @author amira
 */

public class DisplayAvailabilityTimeBlockPresenter implements DisplayAvailabilityTimeBlockOutputBoundary {

    private final List<AvailabilityUiInterface> availabilityViews;

    /**
     * Constructs a DisplayAvailabilityTimeBlockPresenter
     *
     * @param availabilityViews The list of Views observing this presenter
     */
    public DisplayAvailabilityTimeBlockPresenter(List<AvailabilityUiInterface> availabilityViews) {
        this.availabilityViews = availabilityViews;
    }

    /**
     * Display a message that the task was completed.
     *
     * @param availabilityTimeBlockModels model containing display availability time block info.
     */
    @Override
    public void availabilityTimeBlockDisplayed(List<DisplayAvailabilityTimeBlockModel> availabilityTimeBlockModels) {
        for (AvailabilityUiInterface view : availabilityViews) {
            view.drawAvailabilities(availabilityTimeBlockModels);
        }
    }

    /**
     * Adds a view to observe this presenter
     *
     * @param view The view to be added
     */
    @Override
    public void addAvailabilityObserver(AvailabilityUiInterface view) {
        this.availabilityViews.add(view);
    }

}

