package use_cases.create_curriculum;

import entity_factories.CurriculumFactory;
import entity_layer.InMemoryUser;
import entity_layer.Schedule;

/**
 * A use case interactor for the creation of a new curriculum
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author MMachadoUofT
 */
public class CreateCurriculumInteractor implements CreateCurriculumInputBoundary {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final CurriculumFactory curriculumFactory;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CreateCurriculumInteractor(CurriculumFactory curriculumFactory) {
        this.curriculumFactory = curriculumFactory;
    }

    /**
     * Executes the use case for creating a new Curriculum
     *
     * @param name the new Curriculum's name
     */
    @Override
    public void createCurriculum(String name) {
    }

}
