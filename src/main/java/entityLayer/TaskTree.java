package entityLayer;

import java.util.List;

public interface TaskTree extends Iterable<TaskTree> {

    void addSubTask(Task task, int taskID);
    void removeSubTask(int taskID);
    boolean hasSubtasks();
    boolean hasSuperTask();
    TaskTree getSuperTask(); // I'll have this throw an exception if there isn't one
    List<TaskTree> getSubtasks();

}
