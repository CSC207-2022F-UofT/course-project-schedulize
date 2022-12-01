package use_cases.display_task_tree;
/**
 * A presenter for providing output data to the view through an interface.
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class DisplayTaskTreePresenter implements DisplayTaskTreeOutputBoundary {

    private final TaskTreeUIInterface taskTreeUI;
    public DisplayTaskTreePresenter (TaskTreeUIInterface taskTreeUI) {
        this.taskTreeUI = taskTreeUI;
    }

     @Override
     public void displayTree(CurriculumDisplayModel curriculumDisplayModel) {
        this.taskTreeUI.displayTree(curriculumDisplayModel);
    }
}
