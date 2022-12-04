package use_cases.display_task_tree;
/**
 * An interface for the CreateCurriculumInteractor to pass information to the presenter
 * Created: 11/27/2022
 * Last updated 12/01/2022
 *
 * @author Aayush Bhan
 */
public interface DisplayTaskTreeOutputBoundary {
    /**
     * Reformats the provided name and id for the View
     *
     * @param name The tree's task's name
     * @param id the task's ID
     * @return A model of a TaskTree
     */
    TaskTreeDisplayModel prepareTreeView(String name, int id);
}

