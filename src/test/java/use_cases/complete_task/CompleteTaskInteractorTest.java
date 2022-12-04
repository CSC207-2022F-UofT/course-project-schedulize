package use_cases.complete_task;
import entity_factories.*;
import entity_layer.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteTaskInteractorTest {
    static CompleteTaskController controller;
    static CompleteTaskInputBoundary interactor;
    static CompleteTaskOutputBoundary presenter;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;
    static Task readTextbook;
    static Task attendClass;

    /**
     * Set up the user's schedule with a curriculum called "CSC207" that has two
     * tasks: "Read Textbook" and "Attend Lecture", and create instances of the CompleteTask
     * controller, interactor and presenter for testing the complete task use case.
     *
     * @author Bmguiler
     */
    @BeforeAll
    public static void setup(){
        curriculum = new PrebuiltCurriculumFactory().create("CSC207");
        schedule = new PrebuiltScheduleFactory().create();
        activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");

        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        TaskTree readTextbookTT = new CommonTaskTreeFactory().createWithTask("Read Textbook", "Read chapter 1 of Clean Architecture");
        readTextbook = readTextbookTT.getTask();
        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");
        attendClass = attendClassTT.getTask();
        curriculum.getGoal().addSubTaskTree(readTextbookTT);
        curriculum.getGoal().addSubTaskTree(attendClassTT);

        presenter = new CompleteTaskPresenter(new ArrayList<>());
        interactor = new CompleteTaskInteractor(presenter);
        controller = new CompleteTaskController(interactor);

    }

    /**
     * Test that the task "Read Textbook" was completed correctly and that the parent task's
     * completion was updated accordingly.
     *
     * @author Bmguiler
     */
    @Test
    public void testCompleteTask1(){
        InMemoryUser.setActiveUser(activeUser);
        CompletedTaskModel model = new CompletedTaskModel(curriculum.getName(), readTextbook.getName());
        controller.completeTask(curriculum.getID(), readTextbook.getId());

        String expectedPresenter = "The task Read Textbook from CSC207 was successfully completed.";
        String actualPresenter = presenter.taskCompleted(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertEquals(100, readTextbook.getCompletion());
        assertTrue(readTextbook.isComplete());
        assertEquals(50, curriculum.getGoal().getTask().getCompletion());
        assertEquals(0, attendClass.getCompletion());
    }

    /**
     * Test that the task "Attend Lecture" was completed correctly and that the parent task's
     * completion was updated accordingly.
     *
     * @author Bmguiler
     */
    @Test
    public void testCompleteTask2(){
        InMemoryUser.setActiveUser(activeUser);
        CompletedTaskModel model = new CompletedTaskModel(curriculum.getName(), attendClass.getName());
        controller.completeTask(curriculum.getID(), attendClass.getId());

        String expectedPresenter = "The task Attend Lecture from CSC207 was successfully completed.";
        String actualPresenter = presenter.taskCompleted(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertEquals(100, attendClass.getCompletion());
        assertEquals(100, curriculum.getGoal().getTask().getCompletion());
        assertTrue(attendClass.isComplete());
    }

    @Test
    public void testUncomplete1Task(){
        InMemoryUser.setActiveUser(activeUser);
        curriculum.getTaskTreeByID(readTextbook.getId()).completeTask();
        curriculum.getTaskTreeByID(attendClass.getId()).completeTask();

        assertEquals(100, attendClass.getCompletion());
        assertEquals(100, readTextbook.getCompletion());
        assertEquals(100, curriculum.getGoal().getTask().getCompletion());
        assertTrue(attendClass.isComplete());

        CompletedTaskModel model = new CompletedTaskModel(curriculum.getName(), attendClass.getName());
        controller.uncompleteTask(curriculum.getID(), attendClass.getId());

        String expectedPresenter = "The task Attend Lecture from CSC207 was successfully uncompleted.";
        String actualPresenter = presenter.taskUncompleted(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertEquals(0, attendClass.getCompletion());
    }

    @Test
    public void testUncompleteAllTasks(){
        InMemoryUser.setActiveUser(activeUser);
        curriculum.getTaskTreeByID(readTextbook.getId()).completeTask();
        curriculum.getTaskTreeByID(attendClass.getId()).completeTask();

        assertEquals(100, attendClass.getCompletion());
        assertEquals(100, readTextbook.getCompletion());
        assertEquals(100, curriculum.getGoal().getTask().getCompletion());

        CompletedTaskModel model1 = new CompletedTaskModel(curriculum.getName(), attendClass.getName());
        controller.uncompleteTask(curriculum.getID(), attendClass.getId());

        String expectedPresenter1 = "The task Attend Lecture from CSC207 was successfully uncompleted.";
        String actualPresenter1 = presenter.taskUncompleted(model1);
        assertEquals(expectedPresenter1, actualPresenter1);
        assertEquals(0, attendClass.getCompletion());
        assertEquals(50, curriculum.getGoal().getTask().getCompletion());

        CompletedTaskModel model2 = new CompletedTaskModel(curriculum.getName(), readTextbook.getName());
        controller.uncompleteTask(curriculum.getID(), readTextbook.getId());
        String expectedPresenter2 = "The task Read Textbook from CSC207 was successfully uncompleted.";
        String actualPresenter2 = presenter.taskUncompleted(model2);
        assertEquals(expectedPresenter2, actualPresenter2);
        assertEquals(0, readTextbook.getCompletion());
        assertEquals(0, curriculum.getGoal().getTask().getCompletion());
    }
}
