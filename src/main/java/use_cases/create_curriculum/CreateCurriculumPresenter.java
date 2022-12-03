package use_cases.create_curriculum;

import java.util.List;

/**
 * A presenter for providing output data to the view via an interface.
 * Created: 11/27/2022
 * Last updated: 11/27/2022
 *
 * @author MMachadoUofT
 */
public class CreateCurriculumPresenter implements CreateCurriculumOutputBoundary {

    private final List<DashboardUiInterface> dashboardObservers;

    public CreateCurriculumPresenter(List<DashboardUiInterface> dashboardObservers) {
        this.dashboardObservers = dashboardObservers;
    }

    /**
     * Prepares the created curriculum for presentation
     *
     * @param curriculumModel the newly created Curriculum's model
     */
    @Override
    public void displayCurriculum(CurriculumModel curriculumModel) {
        String successfullyCreatedCurriculumMsg = String.format("The %s curriculum (i.d. %d) was successfully created",
                curriculumModel.getCurriculumName(), curriculumModel.getCurriculumID());
        this.dashboardObservers.get(0).createdCurriculum(successfullyCreatedCurriculumMsg);
    }

    @Override
    public void addViewObserver(DashboardUiInterface dashboard) {
        this.dashboardObservers.add(dashboard);
    }
}
