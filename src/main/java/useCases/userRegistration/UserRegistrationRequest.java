package useCases.userRegistration;

public class UserRegistrationRequest {
    private String email;
    private String username;
    private String password1;
    private String password2;

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

    public boolean validPasswordRepeat() {
        return this.password1.equals(this.password2);
    }
}
