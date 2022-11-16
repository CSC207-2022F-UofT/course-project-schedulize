package use_cases.login;

public class LoginException extends RuntimeException {
    public LoginException(String msg) {
        super(msg);
    }
}
