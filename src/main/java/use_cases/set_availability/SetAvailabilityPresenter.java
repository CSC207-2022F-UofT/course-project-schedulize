package use_cases.set_availability;

import java.util.List;

/**
 * Presenter class implemented by OutputBoundary class, used to package information being returned to
 * the display UI (through the ViewInterface).
 *
 * @author od-obas1187
 */
public class SetAvailabilityPresenter implements SetAvailabilityOutputBoundary {

    private final List<SetAvailabilityViewInterface> views;

    /**
     * Sets this class's view interface list to the one provided in the constructor
     *
     * @param views The view interface list provided
     */
    public SetAvailabilityPresenter(List<SetAvailabilityViewInterface> views) {
        this.views = views;
    }

    /**
     * Adds the view interface provided in the parameter to this class's list of view interfaces.
     *
     * @param view A view interface
     */
    @Override
    public void addViewObserver(SetAvailabilityViewInterface view) {
        this.views.add(view);
    }

    /**
     * Confirms that the availabilities were set with a confirmation message.
     *
     * @param returnMessage a message confirming the task was completed.
     */
    @Override
    public void availabilitiesSet(String returnMessage) {
        if (views.size() > 0) {
            views.get(0).successfullySet(returnMessage);
        }
    }

}
