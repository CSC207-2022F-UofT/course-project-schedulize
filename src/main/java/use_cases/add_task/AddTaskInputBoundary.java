package use_cases.add_task;

/**
 * An input boundary interface that is implemented by the Add Task Use Case class.
 *
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public interface AddTaskInputBoundary {
    void addTask(String taskName, String taskDescription, int parentId,
                 int curriculumId);
}
