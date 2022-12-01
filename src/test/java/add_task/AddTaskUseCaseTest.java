package add_task;
import entity_factories.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.add_task.*;
import entity_layer.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing the Add Task Use Case.
 *
 * date created: 12/1/2022
 * last updated: 12/1/2022
 *
 * @author Bmguiler
 */
public class AddTaskUseCaseTest {

    static AddTaskController controller;
    static AddTaskUseCase interactor;
    static AddTaskPresenter presenter;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;


    /**
     * Set up a new user with a schedule that has a curriculum named "CSC207" and
     * create instances of the AddTask controller, interactor and presenter
     * to use for the following tests.
     */
    @BeforeAll
    public static void setup(){
        curriculum = new PrebuiltCurriculumFactory().create("CSC207");
        schedule = new PrebuiltScheduleFactory().create();
        activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");
        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        TaskFactory taskFactory = new CommonTaskFactory();
        TaskTreeFactory taskTreeFactory= new CommonTaskTreeFactory();
        presenter = new AddTaskPresenter();
        interactor = new AddTaskUseCase(presenter, taskFactory, taskTreeFactory);
        controller = new AddTaskController(interactor);
    }

    /**
     * Test adding a new task to an empty curriculum.
     */
    @Test
    public void testAddTaskEmptyCurriculum(){
        InMemoryUser.setActiveUser(activeUser);
        Task parentTask = curriculum.getGoal().getTask();
        int curriculumId = curriculum.getID();
        int parentId = parentTask.getId();

        controller.addTask("Read Textbook",
                "Read Chapter 1 from Clean Architecture", parentId, curriculumId);
        AddTaskModel model = new AddTaskModel("Read Textbook",
                "Read Chapter 1 from Clean Architecture",
                curriculum.getName(), parentTask.getName());
        String expectedPresenter = "New task with name: Read Textbook and description: " +
                "Read Chapter 1 from Clean Architecture was successfully added " +
                "to the curriculum: CSC207 as a subtask of: CSC207.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertTrue(curriculum.getGoal().hasSubTaskTrees());
        assertSame("Read Textbook", curriculum.getGoal().getSubTaskTrees().get(0).getTask().getName());
    }

    /**
     * Test adding two tasks to the curriculum; the second task being a
     * subtask of the first task.
     */
    @Test
    public void testAddTwoTasks1(){
        InMemoryUser.setActiveUser(activeUser);
        Task parentTask1 = curriculum.getGoal().getTask();
        int curriculumId = curriculum.getID();
        int parentTask1Id = parentTask1.getId();
        controller.addTask("Read Textbook",
                "Read Chapter 1 from Clean Architecture", parentTask1Id, curriculumId);

        Task parentTask2 = curriculum.getGoal().getSubTaskTrees().get(0).getTask();
        int parentTask2Id = parentTask2.getId();
        controller.addTask("Do Textbook Questions",
                "Page 100 Questions 1-10", parentTask2Id, curriculumId);
        AddTaskModel model = new AddTaskModel("Do Textbook Questions",
                "Page 100 Questions 1-10", curriculum.getName(),
                parentTask2.getName());

        String expectedPresenter = "New task with name: Do Textbook Questions and description: " +
                "Page 100 Questions 1-10 was successfully added to the curriculum: CSC207" +
                " as a subtask of: Read Textbook.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertTrue(curriculum.getGoal().hasSubTaskTrees());
        assertSame(1, curriculum.getGoal().getSubTaskTrees().size());
        assertTrue(curriculum.getGoal().getChildTaskTreeByID(parentTask2Id).hasSubTaskTrees());
        assertSame("Do Textbook Questions", curriculum.getGoal().
                getChildTaskTreeByID(parentTask2Id).getSubTaskTrees().get(0).getTask().getName());
    }

    /**
     * Test adding two tasks to the curriculum; both the first and second
     * task being subtasks of the goal.
     */
    @Test
    public void testAddTwoTasks2(){
        InMemoryUser.setActiveUser(activeUser);
        Task parentTask = curriculum.getGoal().getTask();
        int curriculumId = curriculum.getID();
        int parentTaskId = parentTask.getId();
        controller.addTask("Read Textbook",
                "Read Chapter 1 from Clean Architecture", parentTaskId, curriculumId);
        controller.addTask("Attend Lecture", "Tuesday 6-8pm at Bahen Centre",
                parentTaskId, curriculumId);
        AddTaskModel model = new AddTaskModel("Attend Lecture",
                "Tuesday 6-8pm at Bahen Centre", curriculum.getName(),
                parentTask.getName());

        String expectedPresenter = "New task with name: Attend Lecture and description: " +
                "Tuesday 6-8pm at Bahen Centre was successfully added to the curriculum: " +
                "CSC207 as a subtask of: CSC207.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertTrue(curriculum.getGoal().hasSubTaskTrees());
        assertSame(2, curriculum.getGoal().getSubTaskTrees().size());
        assertFalse(curriculum.getGoal().getSubTaskTrees().get(0).hasSubTaskTrees());
        assertSame("Read Textbook", curriculum.getGoal().getSubTaskTrees().get(0).getTask().getName());
        assertSame("Attend Lecture", curriculum.getGoal().getSubTaskTrees().get(1).getTask().getName());
    }

    /**
     * Test adding a new task to a curriculum that already has two tasks.
     */
    @Test
    public void testAddTaskNonEmptyCurriculum(){
        InMemoryUser.setActiveUser(activeUser);

        TaskTree finishCodingTT = new CommonTaskTreeFactory().createWithTask("Finish Coding", "Finish Use Cases for CSC207 Project");
        Task finishCoding = finishCodingTT.getTask();
        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");
        curriculum.getGoal().addSubTaskTree(finishCodingTT);
        curriculum.getGoal().addSubTaskTree(attendClassTT);

        int parentId = finishCoding.getId();
        int curriculumId = curriculum.getID();

        controller.addTask("Write Tests",
                "Write tests for use cases", parentId, curriculumId);
        AddTaskModel model = new AddTaskModel("Write Tests",
                "Write tests for use cases", curriculum.getName(),
                finishCoding.getName());

        String expectedPresenter = "New task with name: Write Tests and description: " +
                "Write tests for use cases was successfully added to the curriculum: CSC207" +
                " as a subtask of: Finish Coding.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertTrue(curriculum.getGoal().hasSubTaskTrees());
        assertSame(2, curriculum.getGoal().getSubTaskTrees().size());
        assertTrue(curriculum.getGoal().getSubTaskTrees().get(0).hasSubTaskTrees());
        assertSame("Write Tests", curriculum.getGoal().getSubTaskTrees().get(0).
                getSubTaskTrees().get(0).getTask().getName());
    }
}
