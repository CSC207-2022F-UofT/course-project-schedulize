package task_display_ui;

import entity_factories.CommonTaskTreeFactory;
import entity_factories.CommonUserFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_factories.PrebuiltScheduleFactory;
import entity_layer.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import use_cases.complete_task.*;

public class TaskUiTests {

    // static TaskUiController controller;
    // static TaskUiInputBoundary interactor;
    // static TaskUiOutputBoundary presenter;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;
    // static Task readTextbook;
    static Task attendClass;

    // static TaskUiModel taskUiModel;

    @BeforeAll
    public static void setup(){
        curriculum = new PrebuiltCurriculumFactory().create("CSC207");
        schedule = new PrebuiltScheduleFactory().create();
        activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");

        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask("Attend Lecture",
                "Tuesday 6-8pm at Bahen Centre");
        attendClass = attendClassTT.getTask();
        curriculum.getGoal().addSubTaskTree(attendClassTT);

        // taskUiModel = new TaskUiModel(attendClass.getName(), attendClass.getDescription(), attendClass.getCompletion(),
        //         curriculum.getID(), attendClass.getId());
    }

    @Test
    public void testPresenter(){
        //presenter.getTaskInfo(taskUiModel);
    }

    @Test
    public void testInteractor(){
        //interactor.displayTask(curriculum.getID(), attendClass.getId());
    }

    @Test
    public void testController(){
        TaskUiInputBoundary interactor = new TaskUiTestInteractor();
        TaskUiController controller = new TaskUiController(interactor);
        controller.callInteractor(curriculum.getID(), attendClass.getId());
    }
}