package entityLayer;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonTaskTests {

    Task t1;
    Task t2;
    Task t3;

    @Before
    public void setup() {
        t1 = new CommonTask("n", "d");
        t2 = new CommonTask("n", "d");
        t3 = new CommonTask("n", "d");
    }

    @Test
    public void testFirstTasksIdZeroThenOne() {
        Task t = new CommonTask("Name", "Description");
        Assertions.assertEquals(t.getId(), 0);
        Task t2 = new CommonTask("Name", "Description");
        Assertions.assertEquals(t2.getId(), 1);
        Assertions.assertNotEquals(t.getId(), t2.getId());
    }

    @Test
    public void testCompletionOutOfBounds() {

    }

    @Test void testCompletionOutOfBoundsConstructor() {

    }

}
