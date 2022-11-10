package entityLayer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonTaskTests {

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
