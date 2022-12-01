package add_task;
import entity_factories.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import use_cases.add_task.*;
import entity_layer.*;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testAddTaskEmptyCurriculum(){
        InMemoryUser.setActiveUser(activeUser);
        Task parentTask = curriculum.getGoal().getTask();
        int curriculumId = curriculum.getID();
        int parentId = parentTask.getId();
        AddTaskModel model = new AddTaskModel("Read Textbook",
                "Read Chapter 1 from Clean Architecture",
                curriculum.getName(), parentTask.getName());

        controller.addTask("Read Textbook",
                "Read Chapter 1 from Clean Architecture", parentId, curriculumId);
        String expectedPresenter = "New task with name: Read Textbook and description: " +
                "Read Chapter 1 from Clean Architecture was successfully added " +
                "to the curriculum: CSC207 as a subtask of: CSC207.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);
        assertTrue(curriculum.getGoal().hasSubTaskTrees());
        assertSame("Read Textbook", curriculum.getGoal().getSubTaskTrees().get(0).getTask().getName());
    }

    @Test
    public void testAddTaskNonEmptyCurriculum(){
        InMemoryUser.setActiveUser(activeUser);

        TaskTree readTextbookTT = new CommonTaskTreeFactory().createWithTask("Finish Coding", "Finish Use Cases for CSC207 Project");
        Task finishCoding = readTextbookTT.getTask();
        TaskTree attendClassTT = new CommonTaskTreeFactory().createWithTask("Attend Lecture", "Tuesday 6-8pm at Bahen Centre");
        Task attendClass = attendClassTT.getTask();
        curriculum.getGoal().addSubTaskTree(readTextbookTT);
        curriculum.getGoal().addSubTaskTree(attendClassTT);

        int parentId = finishCoding.getId();
        int curriculumId = curriculum.getID();

        AddTaskModel model = new AddTaskModel("Write Tests",
                "Write tests for use cases", curriculum.getName(),
                finishCoding.getName());

        controller.addTask("Write Tests",
                "Write tests for use cases", parentId, curriculumId);

        String expectedPresenter = "New task with name: Write Tests  and description: " +
                "Write tests for use cases was successfully added to the curriculum: CSC207" +
                " as a subtask of: Finish Coding.";
        String actualPresenter = presenter.taskAdded(model);

        assertEquals(expectedPresenter, actualPresenter);

    }



}
