package use_cases.display_task_tree;


import java.util.ArrayList;
import java.util.List;

/**
 * A model for the DisplayTaskTree interactor to pass through to the Presenter
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author Aayush Bhan
 */
public class TaskTreeDisplayModel {

    private final List<TaskTreeDisplayModel> subtrees = new ArrayList<>();
    private final TaskDisplayModel taskModel;

    public TaskTreeDisplayModel(TaskDisplayModel taskModel, List<TaskTreeDisplayModel> subtrees){
        this.taskModel = taskModel;
        this.subtrees.addAll(subtrees);
    }
    public List<TaskTreeDisplayModel> getSubtrees() {
        return this.subtrees;
    }

    public TaskDisplayModel getTaskModel() {
        return this.taskModel;
    }
}
