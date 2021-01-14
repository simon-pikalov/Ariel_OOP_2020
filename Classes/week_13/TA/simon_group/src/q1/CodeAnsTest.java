package q1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is an answer for q2 -> in order for this to run need to complete more code
 * This is Tests won't Really Run.
 */
class CodeAnsTest {
    car_code testCarCode;
    String code;

    @BeforeEach
    void init(){
        this.testCarCode = new CodeAns(new EmptyCar());
        this.code = "1234#";
    }


    @Test
    void open() {
        assertTrue(this.testCarCode.open(this.code));
        String [] badCodes = {"","11","4321#","1244#"};
        for (String c : badCodes){
            assertFalse(this.testCarCode.open(c),"shouldn't open here");
        }
    }

    @Test
    void isOpen() {
        assertFalse(this.testCarCode.isOpen(),"Car is closed when inited");
        String [] badCodes = {"","11","4321#","1244#"};
        for (String c : badCodes){
            this.testCarCode.open(c);
            assertFalse(this.testCarCode.isOpen(),"shouldn't open here");
        }
        assertTrue(this.testCarCode.isOpen());
    }

    @Test
    void canBeOpen() {
        assertTrue(this.testCarCode.canBeOpen(),"Car is can be Open when inited");
        for (int i = 0 ; i < 4; i++){
            this.testCarCode.open("1111#");
        }
        assertFalse(this.testCarCode.canBeOpen(),"should be looked 3 wrong attempts");
        try {
            Thread.sleep(CodeAns.TIME_OUT+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(this.testCarCode.canBeOpen());
    }
}