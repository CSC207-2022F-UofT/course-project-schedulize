import UI.*;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import create_task_UI.CreateTaskUI;
import dashboard_ui.DashboardUI;
import entity_factories.*;
import entity_layer.PasswordSuggester;
import entity_layer.RandomPasswordGenerator;
import task_display_ui.*;
import task_tree_UI.TaskTreeUI;
import use_cases.add_task.*;
import use_cases.complete_task.*;
import time_manager_UI.SetAvailabilityUI;
import time_manager_UI.DisplayAvailabilityTimeBlockUI;
import use_cases.create_curriculum.*;
import use_cases.display_availability_timeblocks.DisplayAvailabilityTimeBlockController;
import use_cases.display_availability_timeblocks.DisplayAvailabilityTimeBlockInteractor;
import use_cases.display_availability_timeblocks.DisplayAvailabilityTimeBlockPresenter;
import use_cases.display_curriculums.*;
import use_cases.display_task_tree.*;
import use_cases.login.LoginController;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInteractor;
import use_cases.save_user.SaveUserController;
import use_cases.save_user.SaveUserInputBoundary;
import use_cases.save_user.SaveUserInteractor;
import use_cases.set_availability.SetAvailabilityController;
import use_cases.set_availability.SetAvailabilityPresenter;
import use_cases.set_availability.SetAvailabilityUseCase;
import use_cases.suggest_password.PasswordSuggestionController;
import use_cases.suggest_password.PasswordSuggestionInputBoundary;
import use_cases.suggest_password.PasswordSuggestionInteractor;
import use_cases.user_registration.UserRegistrationController;
import use_cases.user_registration.UserRegistrationInteractor;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Cryptograph cipher = new CommonCryptograph();
        UserFactory factory = new CommonUserFactory();
        UserDataStoreGateway storage = new UserStorage(cipher);
        PasswordSuggester suggester = new RandomPasswordGenerator();

        SaveUserInputBoundary saveInteractor = new SaveUserInteractor(storage);
        SaveUserController saveController = new SaveUserController(saveInteractor);
        WindowManager windows = new CommonWindowManager(saveController);

        UserRegistrationInteractor interactor = new UserRegistrationInteractor(factory, storage);
        UserRegistrationController registryController = new UserRegistrationController(interactor);

        PasswordSuggestionInputBoundary suggestionInteractor = new PasswordSuggestionInteractor(suggester);
        PasswordSuggestionController suggestionController = new PasswordSuggestionController(suggestionInteractor);

        LoginInputBoundary loginInteractor = new LoginInteractor(storage);
        LoginController loginController = new LoginController(loginInteractor);

        DisplayCurriculumsOutputBoundary dashboardViewPresenter = new DisplayCurriculumsPresenter(new ArrayList<>());
        DisplayCurriculumsInputBoundary dashboardViewInteractor = new DisplayCurriculumsInteractor(dashboardViewPresenter);
        DisplayCurriculumsController dashboardViewController = new DisplayCurriculumsController(dashboardViewInteractor);

        CreateCurriculumOutputBoundary createCurriculumPresenter = new CreateCurriculumPresenter(new ArrayList<>());
        CurriculumFactory curriculumFactory = new PrebuiltCurriculumFactory();
        CreateCurriculumInputBoundary createCurriculumInteractor = new CreateCurriculumInteractor(curriculumFactory, createCurriculumPresenter);
        CreateCurriculumController createCurriculumController = new CreateCurriculumController(createCurriculumInteractor);

        DashboardUI dashboard = new DashboardUI(windows, dashboardViewController, createCurriculumController);
        dashboardViewPresenter.addViewObserver(dashboard);
        createCurriculumPresenter.addViewObserver(dashboard);

        DisplayTaskTreeOutputBoundary displayTaskTreePresenter = new DisplayTaskTreePresenter();
        DisplayTaskTreeInputBoundary displayTaskTreeInteractor = new DisplayTaskTreeInteractor(displayTaskTreePresenter);
        DisplayTaskTreeController displayTaskTreeController = new DisplayTaskTreeController(displayTaskTreeInteractor);
        TaskTreeUI taskTreeUI = new TaskTreeUI(windows, displayTaskTreeController);

        DisplayAvailabilityTimeBlockPresenter availabilityPresenter = new DisplayAvailabilityTimeBlockPresenter(new ArrayList<>());
        DisplayAvailabilityTimeBlockInteractor availabilityInteractor = new DisplayAvailabilityTimeBlockInteractor(availabilityPresenter);
        DisplayAvailabilityTimeBlockController controller = new DisplayAvailabilityTimeBlockController(availabilityInteractor);
        DisplayAvailabilityTimeBlockUI view = new DisplayAvailabilityTimeBlockUI(windows, controller);
        availabilityPresenter.addAvailabilityObserver(view);

        SetAvailabilityPresenter setAvailabilityPresenter = new SetAvailabilityPresenter(new ArrayList<>());
        SetAvailabilityUseCase setAvailabilityUseCase = new SetAvailabilityUseCase(setAvailabilityPresenter);
        SetAvailabilityController setAvailabilityController = new SetAvailabilityController(setAvailabilityUseCase);
        SetAvailabilityUI setAvailabilitViewUI = new SetAvailabilityUI(windows, setAvailabilityController);
        setAvailabilityPresenter.addViewObserver(setAvailabilitViewUI);

        CompleteTaskOutputBoundary completeTaskPresenter = new CompleteTaskPresenter(new ArrayList<>());
        CompleteTaskInputBoundary completeTaskInteractor = new CompleteTaskUseCase(completeTaskPresenter);
        CompleteTaskController completeTaskController = new CompleteTaskController(completeTaskInteractor);

        TaskUiOutputBoundary taskViewPresenter = new TaskUiModelPresenter(new ArrayList<>());
        TaskUiInputBoundary taskViewInteractor = new TaskUiInteractor(taskViewPresenter);
        TaskUiController taskViewController = new TaskUiController(taskViewInteractor);
        TaskUI taskView = new TaskUI(windows, completeTaskController, taskViewController);
        taskViewPresenter.addViewObserver(taskView);

        TaskTreeFactory taskTreeFactory = new CommonTaskTreeFactory();
        TaskFactory taskFactory = new CommonTaskFactory();
        AddTaskOutputBoundary addTaskPresenter = new AddTaskPresenter();
        AddTaskInputBoundary addTaskInteractor = new AddTaskUseCase(addTaskPresenter, taskFactory, taskTreeFactory);
        AddTaskController addingTask = new AddTaskController(addTaskInteractor);
        JFrame createTaskUI = new CreateTaskUI(windows, addingTask);


        CreateAccountUI createAccountWindow = new CreateAccountUI(windows, registryController, suggestionController);
        JFrame mainWindow = new LoginUI(windows, loginController);
    }
}
