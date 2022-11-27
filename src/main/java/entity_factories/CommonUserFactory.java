package entity_factories;

import entity_layer.CommonUser;
import entity_layer.User;

public class CommonUserFactory implements UserFactory {

    ScheduleFactory scheduleFactory = new CommonScheduleFactory(new CommonTimeBlockManagerFactory());

    @Override
    public User create(String username, String email, String password) {
        User newUser = new CommonUser(username, email, password);
        newUser.setSchedule(scheduleFactory.create());
        return newUser;
    }
}
