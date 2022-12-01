package use_cases.add_task;

/**
 * An output boundary interface that is implemented by the addTaskPresenter class.
 *
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public interface AddTaskOutputBoundary {
    String taskAdded(AddTaskModel newTask);
}
