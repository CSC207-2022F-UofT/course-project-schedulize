package use_cases.display_curriculums;

import java.util.List;

/**
 * A presenter class that provides output data to the dashboard
 *
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */
public class DisplayCurriculumsPresenter implements DisplayCurriculumsOutputBoundary {

    private final List<DisplayCurriculumsInterface> viewObservers;

    public DisplayCurriculumsPresenter(List<DisplayCurriculumsInterface> viewObservers) {
        this.viewObservers = viewObservers;
    }

    /**
     * Prepares the created curriculum for presentation
     * @param curriculumsModel the model for the curriculum to be presented
     */
    @Override
    public void displayCurriculums(CurriculumsModel curriculumsModel) {
        this.viewObservers.get(0).displayCurriculums(curriculumsModel);
    }

    @Override
    public void addViewObserver(DisplayCurriculumsInterface viewObserver) {
        this.viewObservers.add(viewObserver);
    }
}
