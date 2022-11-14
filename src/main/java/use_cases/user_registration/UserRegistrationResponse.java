package use_cases.user_registration;

public class UserRegistrationResponse {
    private final String newUsername;
    private final String password;
    public UserRegistrationResponse(String newUsername, String password) {
        this.newUsername = newUsername;
        this.password = password;
    }

    public String getUsername() {
        return newUsername;
    }

    public String password() {
        return newUsername;
    }
}
