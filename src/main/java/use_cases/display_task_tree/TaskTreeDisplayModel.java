package use_cases.display_task_tree;

/**
 * A model for the DisplayTaskTree interactor to pass through to the Presenter
 * Created: 11/27/2022
 * Last updated: 12/01/2022
 *
 * @author Aayush Bhan
 */
public class TaskTreeDisplayModel {

    private final String name;
    private final int id;

    public TaskTreeDisplayModel(String name, int id) {
        this.name =name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
