package use_cases.display_curriculums;

public class DisplayCurriculumsController {
    private final DisplayCurriculumsInputBoundary interactor;

    public DisplayCurriculumsController(DisplayCurriculumsInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void openDashboard() {
        interactor.displayCurriculums();
    }
}
