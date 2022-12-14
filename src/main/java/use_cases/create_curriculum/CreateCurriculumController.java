package use_cases.create_curriculum;

/**
 * A controller for the creation of a curriculum use case
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author MMachdaoUofT
 */
public class CreateCurriculumController {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final CreateCurriculumInputBoundary inputBoundary;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    /**
     * Constructs a CreateCurriculumController
     *
     * @param inputBoundary the input boundary this controller will use to access the entity layer
     */
    public CreateCurriculumController(CreateCurriculumInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /* ************* *\
    *  Functionality  *
    \* ************* */
    /**
     * The controller method for creating a new curriculum belonging to the active user
     *
     * @param curriculumName the new Curriculum's name
     */
    public void createCurriculum(String curriculumName) {
        inputBoundary.createCurriculum(curriculumName);
    }

}
