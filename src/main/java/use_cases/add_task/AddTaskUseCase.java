package use_cases.add_task;
import entity_factories.TaskFactory;
import entity_factories.TaskTreeFactory;
import entity_layer.*;

/**
 * Use Case for adding a task.
 *
 * Created: 11/20/2022
 * Last updated: 11/21/2022
 *
 * @author Bmguiler
 */

public class AddTaskUseCase implements AddTaskInputBoundary{

    private final AddTaskOutputBoundary presenter;
    private final TaskFactory taskFactory;
    private final TaskTreeFactory taskTreeFactory;


    /**
     * Add Task Use Case constructor method.
     *
     * @param presenter the presenter class for thr UI.
     * @param taskFactory creates a new Task object.
     * @param taskTreeFactory creates a new Task Tree object.
     */
    public AddTaskUseCase(AddTaskOutputBoundary presenter,
                          TaskFactory taskFactory, TaskTreeFactory taskTreeFactory){
        this.presenter = presenter;
        this.taskFactory = taskFactory;
        this.taskTreeFactory = taskTreeFactory;
    }

    /**
     * Given a name and description from the user, add a new task to the
     * curriculum and parent task they chose to add a task to.
     *
     * @param taskName what the user has named the new task.
     * @param taskDescription what the user has given as a description for
     *                        the new task.
     * @param parentId the unique id of the parent task of the new task.
     * @param curriculumId the specific id unique to the curriculum that the
     *                     new task will be in.
     */
    @Override
    public void addTask(String taskName, String taskDescription, int parentId,
                        int curriculumId) {

        Task newTask = this.taskFactory.create(taskName, taskDescription);
        TaskTree newTaskTree = this.taskTreeFactory.create();
        // may need to implement a new line if we want to create a new task with a duration.

        Schedule schedule = InMemoryUser.getActiveUser().getSchedule();
        Curriculum curriculum = schedule.getCurriculum(curriculumId);
        TaskTree parentTaskTree = curriculum.getTaskTreeByID(parentId);
        parentTaskTree.addSubTaskTree(newTaskTree);

        String curriculumName = curriculum.getName();
        String parentTaskName = parentTaskTree.getTask().getName();
        AddTaskModel addedTask = new AddTaskModel(taskName,
                taskDescription, curriculumName, parentTaskName);
        presenter.taskAdded(addedTask);
    }
}
