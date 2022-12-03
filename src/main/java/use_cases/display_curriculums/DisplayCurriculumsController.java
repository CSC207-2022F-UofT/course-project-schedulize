package use_cases.display_curriculums;

/**
 * A controller class called to display curriculums on the dashboard
 *
 * Created: 11/30/2022
 * Last updated: 12/01/2022
 *
 * @author Oswin Gan
 */
public class DisplayCurriculumsController {
    private final DisplayCurriculumsInputBoundary interactor;

    /**
     * Constructor
     * @param interactor the input boundary for displaying curriculums
     */
    public DisplayCurriculumsController(DisplayCurriculumsInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Begins the open dashboard use case
     */
    public void openDashboard() {
        interactor.displayCurriculums();
    }
}
