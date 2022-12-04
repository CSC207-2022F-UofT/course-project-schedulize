package use_cases.display_task_tree;
/**
 * A presenter for providing output data to the view through an interface.
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreePresenter implements DisplayTaskTreeOutputBoundary {

    /**
     * Reformats the provided name and id for the View
     *
     * @param name The tree's task's name
     * @param id the task's ID
     * @return A model of a TaskTree
     */
    @Override
    public TaskTreeDisplayModel prepareTreeView(String name, int id) {
        return new TaskTreeDisplayModel(name, id);
    }
}
