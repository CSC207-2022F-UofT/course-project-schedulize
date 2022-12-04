package use_cases.display_task_tree;

/**
 * An input boundary interface that is implemented by the display tree Use Case class
 * Created: 11/10/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */

public interface DisplayTaskTreeInputBoundary {

    /**
     * Get the root of the desired curriculum, repackaged as a model
     *
     * @param curriculumID the ID of the desired curriculum
     * @return A TaskTree model
     */
    TaskTreeDisplayModel getRoot(int curriculumID);

    /**
     * Creates a list of TaskTree models for each subtree of the tree holding the task with the provided ID
     *
     * @param curriculumID the ID of the curriculum this task belongs to
     * @param taskID the ID of the task with the desired subtrees
     */
    TaskTreeDisplayModel[] getSubtrees(int curriculumID, int taskID);
}

