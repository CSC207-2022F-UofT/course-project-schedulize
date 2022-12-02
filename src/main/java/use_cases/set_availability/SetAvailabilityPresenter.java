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
    private String returnMessage;

    public SetAvailabilityPresenter(List<SetAvailabilityViewInterface> views) {
        this.views = views;
        this.returnMessage = "";
    }

    @Override
    public void addViewObserver(SetAvailabilityViewInterface view) {
        this.views.add(view);
    }

    /**
     * Confirm that the availabilities were set.
     *
     * @param returnMessage a message confirming the task was completed.
     */
    @Override
    public void availabilitiesSet(String returnMessage) {
        this.returnMessage = returnMessage;
    }

}
