package use_cases.user_registration;

public class UserRegistrationRequest {
    private final String email;
    private final String username;
    private final String password1;
    private final String password2;

    public UserRegistrationRequest(String email, String username, String password1, String password2) {
        this.email = email;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getEmail() {
        return this.email;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password1;
    }

    public boolean isValidPasswordRepeat() {
        return this.password1.equals(this.password2);
    }

    public boolean isValidEmail() {
        int atSignIndex = this.email.indexOf("@");

        if (atSignIndex == -1) {
            return false;
        }

        int extensionIndex = this.email.indexOf(".", atSignIndex);

        return extensionIndex != -1;
    }
}
