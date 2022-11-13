package use_cases.user_registration;

public class UserRegistrationResponse {
    private final String newUsername;
    public UserRegistrationResponse(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getMsg() {
        return newUsername;
    }
}
