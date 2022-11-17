package entity_factories;

import entity_layer.Schedule;
import entity_layer.User;

/**
 * A CommonUser class, implements the User interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 *
 * @author MMachadoUofT
 */
public class CommonUser implements User {
    private String username;
    private String email;
    private String password;

    /**
     * Constructor for new empty user
     */
    public CommonUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Get this CommonUser's email.
     *
     * @return this CommonUser's email attribute
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Get this CommonUser's Schedule
     *
     * @return this CommonUser's schedule attribute (Schedule object)
     */
    @Override
    public Schedule getSchedule() {
        return null;
    }

    /**
     * Set this CommonUser's email to the given String
     *
     * @param email this CommonUser's new email
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return whether this CommonUser's email is valid (contains an @ and .)
     *
     * @return true if this CommonUser has a valid email, false otherwise
     */
    @Override
    public boolean hasValidEmail() {
        return false;
    }

    /**
     * Set this CommonUser's password to the given string.
     *
     * @param password this CommonUser's new password
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get this CommonUser's username.
     *
     * @return this CommonUser's username attribute
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Get this CommonUser's password.
     *
     * @return this CommonUser's password attribute
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Set this CommonUser's username to the given String.
     *
     * @param username this CommonUser's new username
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
