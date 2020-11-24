import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * output #1:
 * 0) BBBBBBBBBB
 * 1) BBBBBBBBBB
 * 2) BBBBBBBBBB
 * 3) BBBBBBBBBB
 * 4) BBBBBBBBBB
 * 5) BBBBBBBBBB
 * 6) BBBBBBBBBB
 * 7) BBBBBBBBBB
 * 8) BBBBBBBBBB
 * 9) BBBBBBBBBB
 * 10) BBBBBBBBBB
 * 11) BBBBBBBBBB
 * 12) BBBBBBBBBB
 * 0) 13) BBBBBBBBBB
 * 14) BBBBBBBBBB
 * 15) BBBBBBBBBB
 * 16) BBBBBBBBBB
 * 17) BBBABBBBBBB
 * AAAAAAAAA
 * 18) BBBBBBBBBB
 * 1) AAAAAAAAAA
 * 19) BB2) AAAAAABBBBBBBB
 * AAAA
 * 3) AAAAAAAAAA
 * 4) AAAAAAAAAA
 * 5) AAAAAAAAAA
 * 6) AAAAAAAAAA
 * 7) AAAAAAAAAA
 * 8) AAAAAAAAAA
 * 9) AAAAAAAAAA
 * 10) AAAAAAAAAA
 * 11) AAAAAAAAAA
 * 12) AAAAAAAAAA
 * 13) AAAAAAAAAA
 * 14) AAAAAAAAAA
 * 15) AAAAAAAAAA
 * 16) AAAAAAAAAA
 * 17) AAAAAAAAAA
 * 18) AAAAAAAAAA
 * 19) AAAAAAAAAA
 *
 * output#2
 * 0) BBBBBBBBBB
 * 1) BBBBBBBBBB
 * 2) BBBBBBBBBB
 * 3) BBBBBBBBBB
 * 4) BBBBBBBBBB
 * 5) BBBBBBBBBB
 * 6) BBBBBBBBBB
 * 7) BBBBBBBBBB
 * 8) BBBBBBBBBB
 * 0) AAAAAAAAAA
 * 9) BBBBBBBBBB
 * 1) AAAA10) BBBBBBBBBB
 * AAA11) BBBBBBBBBB
 * AAA
 * 12) BBBBBBBBBB
 * 2) AAAAAAAAAA
 * 3) AAAAAAAAAA
 * 13) BBBBBBBBBB
 * 4) AAAAAAAAAA
 * 14) BBBBBBBBBB
 * 5) AAAAAAAAAA
 * 15) BBBBBBBBBB
 * 6) A16) BBBBBBBBBAAAAAAAAAB
 *
 * 17) BBBBBBBBBB
 * 7) AAAAAAAAAA
 * 18) BBBBBBBBBB
 * 8) AAAAAAAAAA
 * 19) BBBBBBBBBB
 * 9) AAAAAAAAAA
 * 10) AAAAAAAAAA
 * 11) AAAAAAAAAA
 * 12) AAAAAAAAAA
 * 13) AAAAAAAAAA
 * 14) AAAAAAAAAA
 * 15) AAAAAAAAAA
 * 16) AAAAAAAAAA
 * 17) AAAAAAAAAA
 * 18) AAAAAAAAAA
 * 19) AAAAAAAAAA
 */
public class Thread_main {
    public static void main(String[] a)  {
        MyInt c=new MyInt(0);
      //  ArrayList<String> shared_memory = new ArrayList<String>();
        Thread_101 th1 = new Thread_101("A",c);
        Thread_101 th2 = new Thread_101("B",c);
        th1.start();  // calling run() in parallel
        th2.start();
        try {
            th1.join();
            th2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main  c= "+c.get());
        
    }
}
