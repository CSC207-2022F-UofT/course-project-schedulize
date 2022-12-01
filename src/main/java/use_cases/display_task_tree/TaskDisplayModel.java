package use_cases.display_task_tree;

/**
 * A class meant to model the Task entity for displaying.

 * Created: 11/29/2022
 * Last updated: 11/29/2022
 *
 * @author Aayush Bhan
 */
public class TaskDisplayModel {

    private final String name;
    private final int id;

    /**
     * Returns the name and id.
     * @param name the name of the string.
     * @param id the unique id of the name that it belongs to.
     */
    public TaskDisplayModel(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
