package general;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class general {

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }


    @DisplayName("Single test successful")
    @Test
    void testSingleSuccessTest() {
        System.out.println("Success");
    }

    @Test
    @Disabled("Not implemented yet")
    void testShowSomething() {
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {//@AfterAll needs also to be a static method.
        System.out.println("@AfterAll - executed after all test methods.");
    }

    @Test
    void assrtTrue() {
        assertTrue(10 > -1);
    }


    @Test
    void assrtTrueMessege() {
        assertTrue(-10 > -1, "why this didnt work ? ");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
    }

    @Test
    void groupAssertionsBad() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertEquals(7,numbers[0]);
        assertEquals(1,numbers[1]);
        assertEquals(2,numbers[2]);
        assertEquals(3,numbers[3]);
        assertEquals(4,numbers[4]);
    }


    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(Exception.class, () -> {
            Integer.valueOf(str);
        });

    }

    @ParameterizedTest
    @DisplayName("Should create shapes with different numbers of sides")
    @ValueSource(ints = {3, 4, 5, 8, 14})
    void shouldCreateShapesWithDifferentNumbersOfSides(int a) {
        assertEquals(a, a);
    }


}
