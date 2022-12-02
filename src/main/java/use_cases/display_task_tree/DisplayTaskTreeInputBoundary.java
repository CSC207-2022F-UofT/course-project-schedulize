package use_cases.display_task_tree;

/**
 * An input boundary interface that is implemented by the display tree Use Case class
 * Created: 11/10/2022
 * Last updated: 11/28/2022
 *
 * @author Aayush Bhan
 */

public interface DisplayTaskTreeInputBoundary {

    TaskTreeDisplayModel getRoot(int curriculumID);

    TaskTreeDisplayModel[] getSubtrees(int curriculumID, int taskID);
}

