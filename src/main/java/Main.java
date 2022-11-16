import UI.*;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import entity_layer.CommonUserFactory;
import entity_layer.UserFactory;
import use_cases.login.LoginController;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInteractor;
import use_cases.user_registration.UserRegistrationController;
import use_cases.user_registration.UserRegistrationInteractor;

import javax.swing.*;

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

        CreateAccountUI createAccountWindow = new CreateAccountUI(windows, registryController);
        JFrame mainWindow = new LoginUI(windows, loginController);
    }
}
