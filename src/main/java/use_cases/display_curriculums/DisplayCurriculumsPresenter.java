package use_cases.display_curriculums;

import java.util.List;

public class DisplayCurriculumsPresenter implements DisplayCurriculumsOutputBoundary {

    private final List<DisplayCurriculumsInterface> viewObservers;

    public DisplayCurriculumsPresenter(List<DisplayCurriculumsInterface> viewObservers) {
        this.viewObservers = viewObservers;
    }


    @Override
    public void displayCurriculums(CurriculumsModel curriculumsModel) {
        this.viewObservers.get(0).displayCurriculums(curriculumsModel);
    }

    @Override
    public void addViewObserver(DisplayCurriculumsInterface viewObserver) {
        this.viewObservers.add(viewObserver);
    }
}
