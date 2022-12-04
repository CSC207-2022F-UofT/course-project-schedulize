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

    /**
     * Constructs a TaskTreeDisplayModel
     * @param name this model's name
     * @param id the original TaskTree's task ID attribute
     */
    public TaskTreeDisplayModel(String name, int id) {
        this.name =name;
        this.id = id;
    }

    /**
     * Get this model's name
     *
     * @return this model's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get this model's id
     *
     * @return this model's id
     */
    public int getId() {
        return id;
    }
}
