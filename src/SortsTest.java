/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortsTest {
    ArrayList<Integer> number1;
    Sorts sort1;
    ArrayList<Integer> number2;
    Sorts sort2;
    ArrayList<Integer> number3;
    Sorts sort3;
    ArrayList<Integer> number4;
    Sorts sort4;
    ArrayList<Integer> number5;
    Sorts sort5;
    ArrayList<String> number6;
    Sorts sort6;

    @org.junit.Before
    public void setUp(){
        number1 = new ArrayList<>();
        sort1 = new Sorts();
        number2 = new ArrayList<>();
        sort2 = new Sorts();
        number3 = new ArrayList<>();
        sort3 = new Sorts();
        number4 = new ArrayList<>();
        sort4 = new Sorts();
        number5 = new ArrayList<>();
        sort5 = new Sorts();
        number6 = new ArrayList<>();
        sort6 = new Sorts();

    }

    @org.junit.Test
    public void insertionSort() {
        number1.add(10);
        number1.add(2);
        number1.add(78);
        number1.add(4);
        number1.add(45);
        number1.add(32);
        number1.add(7);
        number1.add(11);
        sort1.InsertionSort(number1, 0, 7);
        List<Integer> r1 = Arrays.asList(2, 4, 7, 10, 11, 32, 45, 78);
        assertArrayEquals(r1.toArray(), number1.toArray());
        number2.add(10);
        number2.add(2);
        number2.add(78);
        number2.add(4);
        number2.add(45);
        number2.add(32);
        number2.add(7);
        number2.add(11);
        sort2.InsertionSort(number2, 1, 6);
        List<Integer> r2 = Arrays.asList(10, 2, 4, 7, 32, 45, 78, 11);
        assertArrayEquals(r2.toArray(), number2.toArray());
        number3.add(1);
        number3.add(2);
        number3.add(4);
        number3.add(5);
        number3.add(9);
        number3.add(10);
        number3.add(33);
        sort3.InsertionSort(number3, 1, 4);
        List<Integer> r3 = Arrays.asList(1, 2, 4, 5, 9, 10, 33);
        assertArrayEquals(r3.toArray(), number3.toArray());
        number4.add(10);
        number4.add(6);
        number4.add(5);
        number4.add(4);
        number4.add(4);
        number4.add(1);
        sort4.InsertionSort(number4, 0, 5);
        List<Integer> r4 = Arrays.asList(1, 4, 4, 5, 6, 10);
        assertArrayEquals(r4.toArray(), number4.toArray());
        number5.add(1);
        number5.add(2);
        number5.add(3);
        number5.add(5);
        number5.add(10);
        number5.add(0);
        sort5.InsertionSort(number5, 0, 5);
        List<Integer> r5 = Arrays.asList(0, 1, 2, 3, 5, 10);
        assertArrayEquals(r5.toArray(), number5.toArray());
        number6.add("a");
        number6.add("n");
        number6.add("c");
        number6.add("b");
        number6.add("e");
        number6.add("i");
        sort6.InsertionSort(number6, 0, 5);
        List<String> r6 = Arrays.asList("a", "b", "c", "e", "i", "n");
        assertArrayEquals(r6.toArray(), number6.toArray());


    }

    @org.junit.Test
    public void mergeSort() {
        number1.add(10);
        number1.add(2);
        number1.add(78);
        number1.add(4);
        number1.add(45);
        number1.add(32);
        number1.add(7);
        number1.add(11);
        sort1.MergeSort(number1, 0, 7);
        List<Integer> r1 = Arrays.asList(2, 4, 7, 10, 11, 32, 45, 78);
        assertArrayEquals(r1.toArray(), number1.toArray());

        number2.add(10);
        number2.add(2);
        number2.add(78);
        number2.add(4);
        number2.add(45);
        number2.add(32);
        number2.add(7);
        number2.add(11);
        sort2.MergeSort(number2, 1, 6);
        List<Integer> r2 = Arrays.asList(10, 2, 4, 7, 32, 45, 78, 11);
        assertArrayEquals(r2.toArray(), number2.toArray());

        number3.add(1);
        number3.add(2);
        number3.add(4);
        number3.add(5);
        number3.add(9);
        number3.add(10);
        number3.add(33);
        sort3.MergeSort(number3, 1, 4);
        List<Integer> r3 = Arrays.asList(1, 2, 4, 5, 9, 10, 33);
        assertArrayEquals(r3.toArray(), number3.toArray());

        number4.add(10);
        number4.add(6);
        number4.add(5);
        number4.add(4);
        number4.add(4);
        number4.add(1);
        sort4.MergeSort(number4, 0, 5);
        List<Integer> r4 = Arrays.asList(1, 4, 4, 5, 6, 10);
        assertArrayEquals(r4.toArray(), number4.toArray());

        number5.add(1);
        number5.add(2);
        number5.add(3);
        number5.add(5);
        number5.add(10);
        number5.add(0);
        sort5.MergeSort(number5, 0, 5);
        List<Integer> r5 = Arrays.asList(0, 1, 2, 3, 5, 10);
        assertArrayEquals(r5.toArray(), number5.toArray());
        
        number6.add("a");
        number6.add("n");
        number6.add("c");
        number6.add("b");
        number6.add("e");
        number6.add("i");
        sort6.InsertionSort(number6, 0, 5);
        List<String> r6 = Arrays.asList("a", "b", "c", "e", "i", "n");
        assertArrayEquals(r6.toArray(), number6.toArray());
    }

    @org.junit.Test
    public void quickSort() {
        number1.add(10);
        number1.add(2);
        number1.add(78);
        number1.add(4);
        number1.add(45);
        number1.add(32);
        number1.add(7);
        number1.add(11);
        sort1.QuickSort(number1, 0, 7);
        List<Integer> r1 = Arrays.asList(2, 4, 7, 10, 11, 32, 45, 78);
        assertArrayEquals(r1.toArray(), number1.toArray());
        number2.add(10);
        number2.add(2);
        number2.add(78);
        number2.add(4);
        number2.add(45);
        number2.add(32);
        number2.add(7);
        number2.add(11);
        sort2.QuickSort(number2, 1, 6);
        List<Integer> r2 = Arrays.asList(10, 2, 4, 7, 32, 45, 78, 11);
        assertArrayEquals(r2.toArray(), number2.toArray());
        number3.add(1);
        number3.add(2);
        number3.add(4);
        number3.add(5);
        number3.add(9);
        number3.add(10);
        number3.add(33);
        sort3.QuickSort(number3, 1, 4);
        List<Integer> r3 = Arrays.asList(1, 2, 4, 5, 9, 10, 33);
        assertArrayEquals(r3.toArray(), number3.toArray());
        number4.add(10);
        number4.add(6);
        number4.add(5);
        number4.add(4);
        number4.add(4);
        number4.add(1);
        sort4.QuickSort(number4, 0, 5);
        List<Integer> r4 = Arrays.asList(1, 4, 4, 5, 6, 10);
        assertArrayEquals(r4.toArray(), number4.toArray());
        number5.add(1);
        number5.add(2);
        number5.add(3);
        number5.add(5);
        number5.add(10);
        number5.add(0);
        sort5.QuickSort(number5, 0, 5);
        List<Integer> r5 = Arrays.asList(0, 1, 2, 3, 5, 10);
        assertArrayEquals(r5.toArray(), number5.toArray());
        number6.add("a");
        number6.add("n");
        number6.add("c");
        number6.add("b");
        number6.add("e");
        number6.add("i");
        sort6.InsertionSort(number6, 0, 5);
        List<String> r6 = Arrays.asList("a", "b", "c", "e", "i", "n");
        assertArrayEquals(r6.toArray(), number6.toArray());
    }


}