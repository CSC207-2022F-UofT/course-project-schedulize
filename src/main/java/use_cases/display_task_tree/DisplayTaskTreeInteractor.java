package use_cases.display_task_tree;

import entity_layer.InMemoryUser;
import entity_layer.Task;
import entity_layer.TaskTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A use case interactor for displaying TaskTree
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreeInteractor implements DisplayTaskTreeInputBoundary {

    private final DisplayTaskTreeOutputBoundary displayTaskTreeOutputBoundary;

    public DisplayTaskTreeInteractor(DisplayTaskTreeOutputBoundary displayTaskTreeOutputBoundary) {
        this.displayTaskTreeOutputBoundary = displayTaskTreeOutputBoundary;
    }

    /**
     * Executes the use case for creating a new Curriculum
     *
     * @param curriculumID the id of the Curriculum
     */
    @Override
    public void displayTree(int curriculumID) {
        TaskTree goal = InMemoryUser.getActiveUser().getSchedule().getCurriculum(curriculumID).getGoal();
        TaskTreeDisplayModel goalModel = createTaskTreeModel(goal);
        displayTaskTreeOutputBoundary.displayTree(goalModel);
    }

    /**
     * Creates a model TaskTree based on tree
     *
     * @param tree the original TaskTree entity
     */
    private static TaskTreeDisplayModel createTaskTreeModel(TaskTree tree) {
        List<TaskTreeDisplayModel> subtrees = new ArrayList<>();
        if (tree.hasSubTaskTrees()) {
            for (TaskTree subtree : tree.getSubTaskTrees()) {
                subtrees.add(createTaskTreeModel(subtree));
            }
        }
        TaskDisplayModel taskModel = createTaskModel(tree.getTask());
        return new TaskTreeDisplayModel(taskModel, subtrees);
    }

    /**
     * Creates a model Task
     *
     * @param task the original Task entity
     */
    private static TaskDisplayModel createTaskModel(Task task) {
        return new TaskDisplayModel(task.getName(), task.getId());
    }


}

