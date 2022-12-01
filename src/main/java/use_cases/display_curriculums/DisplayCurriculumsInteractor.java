package use_cases.display_curriculums;

public class DisplayCurriculumsInteractor implements DisplayCurriculumsInputBoundary {

    private final DisplayCurriculumsOutputBoundary presenter;

    public DisplayCurriculumsInteractor(DisplayCurriculumsOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayCurriculums() {

    }
}
