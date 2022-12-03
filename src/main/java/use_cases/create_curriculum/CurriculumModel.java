package use_cases.create_curriculum;

/**
 * A model for the CreateCurriculum interactor to pass through to the Presenter
 * Created: 11/29/2022
 * Last updated: 11/29/2022
 *
 * @author MMachadoUofT
 */
public class CurriculumModel {

    /* ********** *\
    *  Attributes  *
    \* ********** */
    private final String curriculumName;
    private final int curriculumID;

    /* ************ *\
    *  Constructors  *
    \* ************ */
    public CurriculumModel(String name, int id) {
        this.curriculumName = name;
        this.curriculumID = id;
    }

    /* **************** *\
    *  Attribute Access  *
    \* **************** */
    /**
     * Get this Curriculum model's name
     *
     * @return this Curriculum model's name
     */
    public String getCurriculumName() {
        return this.curriculumName;
    }

    /**
     * Get this Curriculum model's id
     *
     * @return this Curriculum model's id
     */
    public int getCurriculumID() {
        return this.curriculumID;
    }

}
