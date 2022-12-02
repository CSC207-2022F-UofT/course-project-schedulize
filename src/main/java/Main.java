import UI.*;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserDataStoreGateway;
import config.UserStorage;
import entity_factories.CommonUserFactory;
import entity_factories.UserFactory;
import entity_layer.PasswordSuggester;
import entity_layer.RandomPasswordGenerator;
import use_cases.login.LoginController;
import use_cases.login.LoginInputBoundary;
import use_cases.login.LoginInteractor;
import use_cases.save_user.SaveUserController;
import use_cases.save_user.SaveUserInputBoundary;
import use_cases.save_user.SaveUserInteractor;
import use_cases.suggest_password.PasswordSuggestionController;
import use_cases.suggest_password.PasswordSuggestionInputBoundary;
import use_cases.suggest_password.PasswordSuggestionInteractor;
import use_cases.user_registration.UserRegistrationController;
import use_cases.user_registration.UserRegistrationInteractor;

import javax.swing.*;

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

        CreateAccountUI createAccountWindow = new CreateAccountUI(windows, registryController, suggestionController);
        JFrame mainWindow = new LoginUI(windows, loginController);
    }
}
