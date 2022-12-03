package use_cases.display_task_tree;
/**
 * A controller for the creation of displaying a TaskTree use case
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreeController {
        private final DisplayTaskTreeInputBoundary interactor;

        public DisplayTaskTreeController(DisplayTaskTreeInputBoundary interactor) {
                this.interactor = interactor;
        }

        public TaskTreeDisplayModel getRoot(int curriculumID) {
                return interactor.getRoot(curriculumID);
        }

        /**
         * The controller method for displaying a tasktree belonging to the active user
         *
         * @param taskID the id of the Curriculum
         */
        public TaskTreeDisplayModel[] getSubtrees(int curriculumID, int taskID){
                return interactor.getSubtrees(curriculumID, taskID);
        }
}
