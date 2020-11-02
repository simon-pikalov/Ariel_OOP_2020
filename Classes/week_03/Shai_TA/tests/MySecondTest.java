import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// For mor info https://junit.org/junit5/docs/current/user-guide/#writing-tests

public class MySecondTest {

    private final NiceStringCollection nsc = new NiceStringCollection();
    @Test
    public void maxCap1() {
        for (int i = 0; i < 10; ++i) {
            nsc.add(String.valueOf(i));
        }
        assertEquals(10, nsc._string_arr.length);
    }

    @Test
    public void maxCap2() {
        for (int i = 0; i < 15; ++i) {
            nsc.add(String.valueOf(i));
        }
        assertEquals(20, nsc._string_arr.length);
    }
}
