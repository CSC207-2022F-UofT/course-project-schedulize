import UI.*;
import config.CommonCryptograph;
import config.Cryptograph;
import config.UserStorage;
import entity_layer.CommonUserFactory;
import use_cases.user_registration.UserRegistrationInteractor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        WindowManager windows = new CommonWindowManager();
        Cryptograph cipher = new CommonCryptograph();
        UserRegistrationInteractor interactor = new UserRegistrationInteractor(new CommonUserFactory(),
                new UserStorage(cipher), new UserRegistrationResponseFormatter());
        UserRegistrationController controller = new UserRegistrationController(interactor);
        CreateAccountUI createAccountWindow = new CreateAccountUI(windows, controller);
        JFrame mainWindow = new LoginUI(windows);
    }
}
