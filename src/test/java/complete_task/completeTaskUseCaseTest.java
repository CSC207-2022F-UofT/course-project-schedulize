package complete_task;
import entity_factories.CommonUser;
import entity_layer.Schedule;
import entity_layer.User;
import entity_layer.InMemoryUser;
import entity_factories.CommonUserFactory;

import org.junit.Test;

public class completeTaskUseCaseTest {

    @Test
    public void create(){
        User activeUser = new CommonUserFactory().create
                ("username", "email@email.com", "password");
        InMemoryUser.setActiveUser(activeUser);
        // give the activeUser a schedule - no method yet






    }
}
