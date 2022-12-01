import UI.*;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import dashboard_ui.DashboardUI;
import entity_factories.CommonUserFactory;
import entity_factories.UserFactory;
import use_cases.create_curriculum.*;
import use_cases.display_curriculums.*;
import use_cases.login.LoginController;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInteractor;
import use_cases.user_registration.UserRegistrationController;
import use_cases.user_registration.UserRegistrationInteractor;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WindowManager windows = new CommonWindowManager();

        Cryptograph cipher = new CommonCryptograph();
        UserFactory factory = new CommonUserFactory();
        UserDataStoreGateway storage = new UserStorage(cipher);

        UserRegistrationInteractor interactor = new UserRegistrationInteractor(factory, storage);
        UserRegistrationController registryController = new UserRegistrationController(interactor);

        LoginInputBoundary loginInteractor = new LoginInteractor(storage);
        LoginController loginController = new LoginController(loginInteractor);

        DisplayCurriculumsOutputBoundary dashboardViewPresenter = new DisplayCurriculumsPresenter(new ArrayList<>());
        DisplayCurriculumsInputBoundary dashboardViewInteractor = new DisplayCurriculumsInteractor(dashboardViewPresenter);
        DisplayCurriculumsController dashboardViewController = new DisplayCurriculumsController(dashboardViewInteractor);

        CreateCurriculumOutputBoundary createCurriculumPresenter = new CreateCurriculumPresenter();
        CreateCurriculumInputBoundary createCurriculumInteractor = new CreateCurriculumInteractor();
        // TODO: Change above to fit implementations
        CreateCurriculumController createCurriculumController = new CreateCurriculumController();


        DashboardUI dashboard = new DashboardUI(windows, dashboardViewController, createCurriculumController);
        dashboardViewPresenter.addViewObserver(dashboard);

        CreateAccountUI createAccountWindow = new CreateAccountUI(windows, registryController);
        JFrame mainWindow = new LoginUI(windows, loginController);
    }
}
