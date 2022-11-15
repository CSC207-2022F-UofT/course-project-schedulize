import config.CommonCryptograph;
import config.Cryptograph;
import entity_layer.CommonUser;
import entity_layer.User;
import config.UserStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserStorageTests {
    static UserStorage storage;
    static User user1;
    static String username1 = "deborah";
    static String password1 = "pokimane";
    static User user2;
    static String username2 = "loki";
    static String password2 = "novaScotia";
    static User user3;
    static String username3 = "nova";
    static String password3 = "dopeAwesome";
    static User user4;
    static String username4 = "maXX##";
    static String password4 = "criminology";

    static HashSet<String> usernames;

    @BeforeAll
    public static void setUp() throws IOException {
        Cryptograph cipher = new CommonCryptograph();
        storage = new UserStorage(cipher);
        user1 = new CommonUser(username1, "shale@lalal.com", password1);
        user2 = new CommonUser(username2, "copy@maker.com", password2);
        user3 = new CommonUser(username3, "lace@grape.com", password3);
        user4 = new CommonUser(username4, "dapper@guy.com", password4);

        usernames = new HashSet<>();
        String[] arr = {username1, username2, username3, username4};
        usernames.addAll(List.of(arr));
        // add users
        storage.saveUser(user1);
        storage.saveUser(user2);
        storage.saveUser(user3);
        storage.saveUser(user4);
    }

    @Test
    public void testAddingUsers() {
        // test users properly added
        for (String username: usernames) {
            assert storage.usernameExists(username);
        }
    }

    @Test
    public void testContainsUser() {
        assert storage.usernameExists(username1);
    }

    @Test
    public void testNotContainsUser() {
        assert !storage.usernameExists("not a username");
    }

    @Test
    public void testInitialization() {
        Cryptograph cipher = new CommonCryptograph();
        UserStorage ds = new UserStorage(cipher);
        for (String username: usernames) {
            assert ds.usernameExists(username);
        }
    }

    @Test
    public void testUserLoad() throws IOException {
        User experimentUser = storage.loadUser(username1, password1);
        assertEquals(experimentUser.getUsername(), user1.getUsername());
        assertEquals(experimentUser.getEmail(), user1.getEmail());
        assertEquals(experimentUser.getPassword(), user1.getPassword());
    }

    @Test
    public void testInvalidUserLoad() throws IOException {
        try {
            storage.loadUser(username1, password2);
        } catch (StreamCorruptedException error) {
            return;
        }
        throw new RuntimeException();
    }

    @AfterAll
    public static void tearDown() {
        storage.removeUser(username1);
        storage.removeUser(username2);
        storage.removeUser(username3);
        storage.removeUser(username4);
    }
}
