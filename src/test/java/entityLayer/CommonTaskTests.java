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
        Assertions.assertEquals(0, t1.getId());
        Assertions.assertEquals(1, t2.getId());
        Assertions.assertNotEquals(t1.getId(), t2.getId());
    }

    @Test
    public void testCompletionOutOfBounds() {
        t1.setCompletion(41);
        t1.setCompletion(103);
        Assertions.assertEquals(41, t1.getCompletion());
        t2.setCompletion(-12);
        Assertions.assertEquals(0, t2.getCompletion());
    }

    @Test
    void testCompletionOutOfBoundsConstructor() {
        Task t = new CommonTask("n", "d", 132);
        Task t_ = new CommonTask("n", "d", -12);
        Assertions.assertEquals(100, t.getCompletion());
        Assertions.assertEquals(0, t_.getCompletion());
    }

}
