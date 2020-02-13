import static org.junit.Assert.*;
import org.junit.Test;

public class FilkTest {
    /**
     * test the verifies correctness of Filk.isSameNumber
     */
    @Test
    public void TestFlik() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(129, 129));
    }
}
