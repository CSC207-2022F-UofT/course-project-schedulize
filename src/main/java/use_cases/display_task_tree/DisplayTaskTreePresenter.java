package use_cases.display_task_tree;
/**
 * A presenter for providing output data to the view through an interface.
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreePresenter implements DisplayTaskTreeOutputBoundary {


    @Override
    public TaskTreeDisplayModel prepareTreeView(String name, int id) {
        return new TaskTreeDisplayModel(name, id);
    }
}
