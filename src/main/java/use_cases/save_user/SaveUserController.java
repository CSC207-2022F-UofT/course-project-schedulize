package use_cases.save_user;

public class SaveUserController {

    private final SaveUserInputBoundary interactor;

    public SaveUserController(SaveUserInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void saveInMemoryUser() {
        interactor.saveInMemoryUser();
    }
}
