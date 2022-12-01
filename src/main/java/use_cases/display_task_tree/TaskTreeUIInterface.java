package use_cases.display_task_tree;
/**
 * An interface for the DisplayTaskTreeInteractor to pass information to the presenter.
 * Created: 11/27/2022
 * Last updated 12/01/2022
 *
 * @author Aayush Bhan
 */
public interface TaskTreeUIInterface {

    void displayTree(CurriculumDisplayModel curriculumDisplayModel);
}
