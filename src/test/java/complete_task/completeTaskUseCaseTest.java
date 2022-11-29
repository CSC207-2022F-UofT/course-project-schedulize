package complete_task;
import entity_factories.*;
import entity_layer.*;
import org.junit.Before;
import use_cases.complete_task.*;

import org.junit.Test;

public class completeTaskUseCaseTest {
    static CompleteTaskController controller;
    static CompleteTaskUseCase interactor;
    static CompletedTaskModel model;
    static CompleteTaskPresenter presenter;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;

    @Before
    public void setup(){
        curriculum = new PrebuiltCurriculumFactory().create("CSC207");
        schedule = new PrebuiltScheduleFactory().create();

        activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");
        Task readTextbook = new CommonTaskFactory().create("Read Textbook", "Read chapter 1 of Clean Architecture");
        Task attendClass = new CommonTaskFactory().create("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");

        activeUser.setSchedule(schedule);
        schedule.addCurriculum(curriculum);

        TaskTree readTextbookTT = new CommonTaskTreeFactory().createWithTask(readTextbook.getName(), readTextbook.getDescription());
        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask(attendClass.getName(), attendClass.getDescription());
        curriculum.getGoal().addSubTaskTree(readTextbookTT);
        curriculum.getGoal().addSubTaskTree(attendClassTT);


        controller = new CompleteTaskController(interactor);
        interactor = new CompleteTaskUseCase(presenter);
        model = new CompletedTaskModel(curriculum.getName(), readTextbook.getName());
        presenter = new CompleteTaskPresenter();
    }

    @Test
    public void testCompleteTask(){
        InMemoryUser.setActiveUser(activeUser);

    }
}
