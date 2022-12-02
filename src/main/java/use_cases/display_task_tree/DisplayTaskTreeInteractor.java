package use_cases.display_task_tree;

import entity_layer.InMemoryUser;
import entity_layer.Task;
import entity_layer.TaskTree;

import java.util.ArrayList;
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

    public DisplayTaskTreeInteractor(DisplayTaskTreeOutputBoundary presenter) {
        this.presenter = presenter;
    }
    @Override
    public TaskTreeDisplayModel getRoot(int curriculumID) {
        TaskTree root = InMemoryUser.getActiveUser().getSchedule().getCurriculum(curriculumID).getGoal();
        return presenter.prepareTreeView(root.getTask().getName(), root.getTask().getId());
    }

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
