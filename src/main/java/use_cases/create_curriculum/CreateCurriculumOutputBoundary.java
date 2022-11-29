package use_cases.create_curriculum;

/**
 * An interface for the CreateCurriculumInteractor to pass information to the presenter
 * Created: 11/27/2022
 * Last updated 11/29/2022
 *
 * @author MMachadoUofT
 */
public interface CreateCurriculumOutputBoundary {

    /**
     * Prepares the created curriculum for presentation
     *
     * @param curriculumModel the newly created Curriculum's model
     */
    void displayCurriculum(CurriculumModel curriculumModel);

}
