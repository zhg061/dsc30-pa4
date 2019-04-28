/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTest {
    ArrayList<Integer> number1;
    ArrayList<Integer> number2;
    ArrayList<Integer> number3;
    ArrayList<String> number4;
    BinarySearch<Integer> bs;
    BinarySearch<String> BS;

    @org.junit.Before
    public void setUp(){
        number1 = new ArrayList<>();
        number2 = new ArrayList<>();
        number3 = new ArrayList<>();
        number4 = new ArrayList<>();
        bs = new BinarySearch<>();
        BS = new BinarySearch<>();

    }

    @org.junit.Test
    public void binarySearch() {
        number1.add(2);
        number1.add(4);
        number1.add(7);
        number1.add(10);
        number1.add(11);
        number1.add(32);
        number1.add(45);
        number1.add(87);
        assertEquals(new Integer(6),bs.binarySearch(number1, 0, 7,45));

        number2.add(2);
        number2.add(4);
        number2.add(10);
        number2.add(11);
        number2.add(45);
        number2.add(70);
        number2.add(87);
        assertEquals(new Integer(4),bs.binarySearch(number2, 0, 6,45));

        number3.add(2);
        number3.add(4);
        number3.add(10);
        number3.add(11);
        number3.add(45);
        number3.add(70);
        number3.add(87);
        assertEquals(null,bs.binarySearch(number3, 0, 6,100));

        number4.add("a");
        number4.add("b");
        number4.add("c");
        number4.add("n");
        number4.add("o");
        assertEquals(new Integer(4),BS.binarySearch(number4, 0, 4,"o"));

    }
}