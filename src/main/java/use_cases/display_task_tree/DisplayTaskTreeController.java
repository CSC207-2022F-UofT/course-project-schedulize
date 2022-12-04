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

        /**
         * Constructs a DisplayTaskTreeController
         *
         * @param interactor the output boundary this Controller will use to access the entity layer
         */
        public DisplayTaskTreeController(DisplayTaskTreeInputBoundary interactor) {
                this.interactor = interactor;
        }

        /**
         * Get the root of the desired curriculum, repackaged as a model
         *
         * @param curriculumID the ID of the desired curriculum
         * @return A TaskTree model
         */
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
