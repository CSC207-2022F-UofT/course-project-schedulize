package use_cases.display_task_tree;
/**
 * An interface for the CreateCurriculumInteractor to pass information to the presenter
 * Created: 11/27/2022
 * Last updated 11/29/2022
 *
 * @author Aayush Bhan
 */
public interface DisplayTaskTreeOutputBoundary {

    /**
     * Prepares the displayed TaskTree for presentation
     *
     * @param curriculumDisplayModel the id of Curriculum's model
     */
    void displayTree(CurriculumDisplayModel curriculumDisplayModel);

}
