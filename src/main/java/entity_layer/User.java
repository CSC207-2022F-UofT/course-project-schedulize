package entity_layer;

import java.io.Serializable;

/**
 * An interface for Users, used as a layer of abstraction. Implemented by the CommonUser class.
 * Created: 10/31/2022
 * Last updated: 11/4/2022
 *
 * @author MMachadoUofT
 */
public interface User extends Serializable {

    /**
     * Get this User's email.
     *
     * @return this User's email attribute
     */
    String getEmail();

    /**
     * Get this User's Schedule
     *
     * @return this User's schedule attribute (Schedule object)
     */
    Schedule getSchedule();

    /**
     * Set this User's schedule.
     *
     * @param schedule this User's new schedule
     */
    void setSchedule(Schedule schedule);

    /**
     * Set this User's email to the given String
     *
     * @param email this User's new email
     */
    void setEmail(String email);

    /**
     * Return whether this User's email is valid (contains an @ and .)
     *
     * @return true if this user has a valid email, false otherwise
     */
    boolean hasValidEmail();

    /**
     * Set this user's password to the given string.
     *
     * @param password this User's new password
     */
    void setPassword(String password);

    /**
     * get this user's password as a String
     */
    String getPassword();

    /**
     * Get this User's username.
     * @return this User's username attribute
     */
    String getUsername();

    /**
     * Set this User's username to the given String.
     *
     * @param username this User's new username
     */
    void setUsername(String username);

}
