package add_task;
import entity_factories.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.add_task.*;
import entity_layer.*;


public class AddTaskUseCaseTest {

    static AddTaskController controller;
    static AddTaskUseCase interactor;
    static AddTaskPresenter presenter;
    static User activeUser;
    static Schedule schedule;
    static Curriculum curriculum;


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





}
