package complete_task;
import entity_factories.*;
import entity_layer.*;
import use_cases.complete_task.*;

import org.junit.Test;

public class completeTaskUseCaseTest {
    static CompleteTaskController controller;
    // static CompleteTaskInputBoundary input;
    static CompleteTaskUseCase interactor;
    static CompleteTaskPresenter presenter;
    static User activeUser;

    @Test
    public void setup(){
        TaskFactory taskFactory = new CommonTaskFactory();
        // what do date times look like?
        TimeBlock timeBlock = new CommonTimeBlockFactory().create();
        TimeBlockManagerFactory timeBlockManager = new CommonTimeBlockManagerFactory().createWithTimeBlocks();
        TaskTreeFactory taskTree = (TaskTreeFactory) new CommonTaskTreeFactory().create();
        Curriculum curriculum = new CommonCurriculumFactory(taskTree, taskFactory, timeBlockManager).create("CSC207");
        Schedule schedule = new CommonScheduleFactory(timeBlockManager).create();



        activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");
        Task readTextbook = new CommonTaskFactory().create("Read Textbook", "Read chapter 1 of Clean Architecture");
        Task attendClass = new CommonTaskFactory().create("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");
        //add these tasks to the schedule and complete them
        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);





        InMemoryUser.setActiveUser(activeUser);





        // input =
        controller = new CompleteTaskController(input);

    }
}
