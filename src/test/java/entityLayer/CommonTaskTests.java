package entityLayer;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommonTaskTests {

    private Task t1;
    private Task t2;
    private Task t3;

    @BeforeEach
    public void setup() {
        t1 = new CommonTask("n", "d");
        t2 = new CommonTask("n", "d");
        t3 = new CommonTask("n", "d");
    }

    @Test
    public void testFirstTasksIdZeroThenOne() {
        Assertions.assertEquals(t1.getId(), 0);
        Assertions.assertEquals(t2.getId(), 1);
        Assertions.assertNotEquals(t1.getId(), t2.getId());
    }

    @Test
    public void testCompletionOutOfBounds() {
        t1.setCompletion(41);
        t1.setCompletion(103);
        Assertions.assertEquals(t1.getCompletion(), 41);
        t2.setCompletion(-12);
        Assertions.assertEquals(t2.getCompletion(), 0);
    }

    @Test
    void testCompletionOutOfBoundsConstructor() {
        Task t = new CommonTask("n", "d", 132);
        Task t_ = new CommonTask("n", "d", -12);
        Assertions.assertEquals(t.getCompletion(), 100);
        Assertions.assertEquals(t_.getCompletion(), 0);
    }

}
