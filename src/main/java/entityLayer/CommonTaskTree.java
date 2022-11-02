package entityLayer;

import java.util.Iterator;
import java.util.List;

public class CommonTaskTree implements TaskTree {

    @Override
    public void addSubTask(Task task, int taskID) {

    }

    @Override
    public void removeSubTask(int taskID) {

    }

    @Override
    public boolean hasSubtasks() {
        return false;
    }

    @Override
    public boolean hasSuperTask() {
        return false;
    }

    @Override
    public TaskTree getSuperTask() {
        return null;
    }

    @Override
    public List<TaskTree> getSubtasks() {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<TaskTree> iterator() {
        return null;
    }
}
