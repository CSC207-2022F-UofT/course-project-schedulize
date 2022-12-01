package use_cases.display_curriculums;

public class DisplayCurriculumsPresenter implements DisplayCurriculumsOutputBoundary {

    private final DisplayCurriculumsInterface view;

    public DisplayCurriculumsPresenter(DisplayCurriculumsInterface view) {
        this.view = view;
    }

    @Override
    public void displayCurriculums(CurriculumsModel curriculumsModel) {
        this.view.displayCurriculums(curriculumsModel);
    }
}
