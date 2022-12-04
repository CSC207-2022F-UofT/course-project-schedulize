package use_cases.display_task_tree;

import entity_layer.InMemoryUser;
import entity_layer.TaskTree;

import java.util.List;

/**
 * A use case interactor for displaying TaskTree
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreeInteractor implements DisplayTaskTreeInputBoundary {

    private final DisplayTaskTreeOutputBoundary presenter;

    /**
     * Constructs a DisplayTaskTreeInteractor
     *
     * @param presenter The output boundary that this interactor will use to return information to the view
     */
    public DisplayTaskTreeInteractor(DisplayTaskTreeOutputBoundary presenter) {
        this.presenter = presenter;
    }

    /**
     * Get the root of the desired curriculum, repackaged as a model
     *
     * @param curriculumID the ID of the desired curriculum
     * @return A TaskTree model
     */
    @Override
    public TaskTreeDisplayModel getRoot(int curriculumID) {
        TaskTree root = InMemoryUser.getActiveUser().getSchedule().getCurriculum(curriculumID).getGoal();
        return presenter.prepareTreeView(root.getTask().getName(), root.getTask().getId());
    }

    /**
     * Creates a list of TaskTree models for each subtree of the tree holding the task with the provided ID
     *
     * @param curriculumID the ID of the curriculum this task belongs to
     * @param taskID the ID of the task with the desired subtrees
     */
    @Override
    public TaskTreeDisplayModel[] getSubtrees(int curriculumID, int taskID) {
        TaskTree root = InMemoryUser.getActiveUser().getSchedule().getCurriculum(curriculumID).getTaskTreeByID(taskID);

        List<TaskTree> subtrees = root.getSubTaskTrees();
        TaskTreeDisplayModel[] subtreeInfo = new TaskTreeDisplayModel[subtrees.size()];
        for (int i = 0; i < subtrees.size(); i++) {
            subtreeInfo[i] = presenter.prepareTreeView(subtrees.get(i).getTask().getName(),
                    subtrees.get(i).getTask().getId());
        }

        return subtreeInfo;
    }

}
