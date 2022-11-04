package entityLayer;

/**
 * A CommonUser class, implements the User interface.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 *
 * @author MMachadoUofT
 */
public class CommonUser implements User {

    /**
     * Get this CommonUser's email.
     *
     * @return this CommonUser's email attribute
     */
    @Override
    public String getEmail() {
        return null;
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

    }

    /**
     * Get this CommonUser's username.
     *
     * @return this CommonUser's username attribute
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * Set this CommonUser's username to the given String.
     *
     * @param username this CommonUser's new username
     */
    @Override
    public void setUsername(String username) {

    }
}
