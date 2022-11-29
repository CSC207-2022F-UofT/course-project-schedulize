package use_cases.create_curriculum;

/**
 * An interface for the controller to access the CreateCurriculumInteractor
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author MMachadoUofT
 */
public interface CreateCurriculumInputBoundary {

    /**
     * Executes the use case for creating a new Curriculum
     *
     * @param name the new Curriculum's name
     */
    void createCurriculum(String name);

}
