package use_cases.display_task_tree;
/**
 * A controller for the creation of displaying a TaskTree use case
 * Created: 11/27/2022
 * Last updated: 11/29/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreeController {

        private final DisplayTaskTreeInputBoundary displayTaskTreeInputBoundary;

        public DisplayTaskTreeController(DisplayTaskTreeInputBoundary displayTaskTreeInputBoundary) {
                this.displayTaskTreeInputBoundary= displayTaskTreeInputBoundary;
        }

        /**
         * The controller method for displaying a tasktree belonging to the active user
         *
         * @param curriculumID the id of the Curriculum
         */
        public void displayTree(int curriculumID) {
                this.displayTaskTreeInputBoundary.displayTree(curriculumID);
        }
}
