package use_cases.create_curriculum;

/**
 * A presenter for providing output data to the view via an interface.
 * Created: 11/27/2022
 * Last updated: 11/27/2022
 *
 * @author MMachadoUofT
 */
public class CreateCurriculumPresenter implements CreateCurriculumOutputBoundary {

    // private final DashboardUiInterface dashboard;

    /*
    public CreateCurriculumPresenter(DashboardUiInterface dashboard) {
        this.dashboard = dashboard;
    }
    TODO: Connect this presenter to the dashboard
     */

    /**
     * Prepares the created curriculum for presentation
     *
     * @param curriculumModel the newly created Curriculum's model
     */
    @Override
    public void displayCurriculum(CurriculumModel curriculumModel) {
        String successfullyCreatedCurriculumMsg = String.format("The %s curriculum (i.d. %d) was successfully created",
                curriculumModel.getCurriculumName(), curriculumModel.getCurriculumID());
        // this.dashboard.displayCurriculum(successfullyCreatedCurriculumMsg);
        // TODO: Connect this to the dashboard
    }
}
