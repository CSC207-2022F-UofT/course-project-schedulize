package complete_task;
import entity_factories.*;
import entity_layer.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.complete_task.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class completeTaskUseCaseTest {
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
        //readTextbook = new CommonTaskFactory().create("Read Textbook", "Read chapter 1 of Clean Architecture");
        //attendClass = new CommonTaskFactory().create("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");

        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        TaskTree readTextbookTT = new CommonTaskTreeFactory().createWithTask("Read Textbook", "Read chapter 1 of Clean Architecture");
        readTextbook = readTextbookTT.getTask();
        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");
        attendClass = attendClassTT.getTask();
        curriculum.getGoal().addSubTaskTree(readTextbookTT);
        curriculum.getGoal().addSubTaskTree(attendClassTT);

        presenter = new CompleteTaskPresenter();
        interactor = new CompleteTaskUseCase(presenter);
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
        assertEquals(readTextbook.getCompletion(), 100);
        assertTrue(readTextbook.isComplete());
        assertEquals(curriculum.getGoal().getTask().getCompletion(), 50);
        assertEquals(attendClass.getCompletion(), 0);
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
        assertEquals(attendClass.getCompletion(), 100);
        assertEquals(curriculum.getGoal().getTask().getCompletion(), 100);
        assertTrue(attendClass.isComplete());
    }
}
