import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertEquals;

// For mor info https://junit.org/junit5/docs/current/user-guide/#writing-tests

public class MyFirstTest {

    private final NiceStringCollection nsc = new NiceStringCollection();

    @Test
    @DisplayName("Add String Test")
    public void addString() {
        System.out.println("Add String Test");
        nsc.add("One");
        nsc.add("Two");
        assertEquals(2, nsc.size());
    }
}
