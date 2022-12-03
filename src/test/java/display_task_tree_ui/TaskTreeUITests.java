package display_task_tree_ui;

/**
 * Test for TaskTreeUI
 *
 * Created: 12/01/2022
 * Last updated: 12/03/2022
 *
 * @author Aayush Bhan
 */

import entity_factories.CommonTaskTreeFactory;
import entity_factories.CommonUserFactory;
import entity_factories.PrebuiltCurriculumFactory;
import entity_factories.PrebuiltScheduleFactory;
import entity_layer.*;
import org.junit.jupiter.api.*;
import task_display_ui.*;
import task_tree_UI.TaskTreeUI;
import use_cases.display_task_tree.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTreeUITests {

    static Curriculum curriculum;
    static Task attendClass;


    @Test
    public void testPresenter(){
        DisplayTaskTreePresenter testView = new DisplayTaskTreePresenter();
        //DisplayTaskTreeOutputBoundary presenter = new DisplayTaskTreePresenter(testView);
       // DisplayTaskTreeInputBoundary interactor = new DisplayTaskTreeInteractor(presenter);
       // interactor.getSubtrees(curriculum.getID(), attendClass.getId());
        //TaskTreeDisplayModel tasktreeModel = treeView.TaskTreeDisplayModel();
       // assertEquals(attendClass.getId(), tasktreeModel.getId());
      //  assertEquals(attendClass.getName(), tasktreeModel.getName());
    }

    @Test
    public void testInteractor(){
        DisplayTaskTreePresenter presenter = new DisplayTaskTreePresenter();
        DisplayTaskTreeInputBoundary interactor = new DisplayTaskTreeInteractor(presenter);
        interactor.getSubtrees(curriculum.getID(), attendClass.getId());
       // TaskTreeDisplayModel tasktreeModel = interactor.TaskTreeDisplayModel();
        //assertEquals(attendClass.getName(), tasktreeModel.getName());

    }

    @Test
    public void testController(){
        //DisplayTaskTreeInteractor interactor = new DisplayTaskTreeInteractor();
        //DisplayTaskTreeController controller = new DisplayTaskTreeController(interactor);
        //controller.getSubtrees(curriculum.getId(), attendClass.getId());
        //assertEquals(curriculum.getID(), interactor.getClass());
    }
}
