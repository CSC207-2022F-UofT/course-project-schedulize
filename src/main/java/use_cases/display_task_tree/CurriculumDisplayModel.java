package use_cases.display_task_tree;
/**
 * A Curriculum Display Model
 * Created: 11/27/2022
 * Last updated 11/29/2022
 *
 * @author Aayush Bhan
 */
public class CurriculumDisplayModel {
    private final int id;
    private final TaskTreeDisplayModel treeModel;

    public CurriculumDisplayModel(int id, TaskTreeDisplayModel treeModel){
        this.id =id;
        this.treeModel = treeModel;

    }

    public int getId() {
        return id;
    }

    public TaskTreeDisplayModel getTreeModel() {
        return treeModel;
    }
}

