package entity_factories;

import entity_layer.CommonUser;
import entity_layer.User;

/**
 * A CommonUserFactory to create CommonUser implementations of the User interface.
 */
public class CommonUserFactory implements UserFactory {

    ScheduleFactory scheduleFactory = new CommonScheduleFactory(new CommonTimeBlockManagerFactory());

    /**
     * Creates a CommonUser object
     *
     * @param username The CommonUser's username
     * @param email The CommonUser's email
     * @param password The CommonUser's password
     * @return a new CommonUser instance
     */
    @Override
    public User create(String username, String email, String password) {
        User newUser = new CommonUser(username, email, password);
        newUser.setSchedule(scheduleFactory.create());
        return newUser;
    }
}
