import entity_layer.CommonUser;
import entity_layer.User;
import entity_layer.UserStorage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class UserStorageTests {
    UserStorage storage;
    User user1;
    String username1 = "deborah";
    String password1 = "pokimane";
    User user2;
    String username2 = "loki";
    String password2 = "novaScotia";
    User user3;
    String username3 = "nova";
    String password3 = "dopeAwesome";
    User user4;
    String username4 = "maXX##";
    String password4 = "criminology";

    HashSet<String> usernames;

    @Before
    public void setUp() throws IOException {
        storage = new UserStorage();
        user1 = new CommonUser(username1, "shale@lalal.com", password1);
        user2 = new CommonUser(username2, "copy@maker.com", password2);
        user3 = new CommonUser(username3, "lace@grape.com", password3);
        user4 = new CommonUser(username4, "dapper@guy.com", password4);

        usernames = new HashSet<>();
        String[] arr = {username1, username2, username3, username4};
        usernames.addAll(List.of(arr));
        testAddingUsers();
    }

    @Test(timeout = 100)
    public void testAddingUsers() throws IOException {
        storage.saveUser(user1);
        storage.saveUser(user2);
        storage.saveUser(user3);
        storage.saveUser(user4);

        for (String username: usernames) {
            assert storage.usernameExists(username);
        }
    }

    @Test(timeout = 100)
    public void testContainsUser() {
        assert storage.usernameExists(username1);
    }

    @Test(timeout = 100)
    public void testNotContainsUser() {
        assert !storage.usernameExists("not a username");
    }

    @Test(timeout = 100)
    public void testInitialization() {
        UserStorage ds = new UserStorage();
        for (String username: usernames) {
            assert ds.usernameExists(username);
        }
    }

    @After
    public void tearDown() {
        storage.removeUser(username1);
        storage.removeUser(username2);
        storage.removeUser(username3);
        storage.removeUser(username4);
    }
}
