/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class check the run time for binary search, linear serach,
 * insertion sort, merge sort, and quick sort
 */
public class RuntimeAnalysis {

    HashMap<Long, Integer> a = new HashMap<>();


    private static final int NUM_DATA = 100000;
    private static final int NUM_SEARCH = 50000;
    private static final int NUM_RUN = 10;
    private static final int NUM_TEST = 5;
    private static final int MIN = 0;
    private static final int MAX = 100000;
    private static Sorts<Integer> sort = new Sorts<>();
    private static BinarySearch<Integer> binary = new BinarySearch<>();

    /**
     * Returns an ArrayList of random numbers
     *
     * @param size the number of random numbers wanted
     * @param min the min value for random number
     * @param max the max value for random number
     * @return an ArrayList of random numbers
     */
    public static ArrayList<Integer> randomNumbers(int size, int min, int max) {

        ArrayList<Integer> randNums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randNums.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return randNums;
    }

    /**
     *  check the time it takes to run insertion sort
     * @param data
     * @param numRun
     */

    public static void timeInsertionSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        
        // iterating through the number of runs
        for (int i = 0; i < numRun; i++) {
            //check the initail or current time of runs
            startTime = System.currentTimeMillis();
            sort.InsertionSort(data, 0, data.size() - 1);
            //after insertion sort, increment the time each run to the total time
            totalTime += System.currentTimeMillis();
            // subtract the total time to the start time to eliminate the overlapping
            // or initial time to get the real time
            totalTime -= startTime;
        }

        System.out.println();
        System.out.println("Benchmarking insertion sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * this method test the run time for merge sort
     * @param data
     * @param numRun
     */

    public static void timeMergeSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        
        // loop numRun times

        for (int i = 0; i < numRun; i++) {
            // check the initial time it takes
            startTime = System.currentTimeMillis();
            // call merge sort method
            sort.MergeSort(data, 0, data.size() - 1);
            // add the current time to the total time
            totalTime += System.currentTimeMillis();
            // subtract the total time to start time to eliminate the overlapping time
            totalTime -= startTime;
        }


        
        System.out.println();
        System.out.println("Benchmarking merge sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * check the run time for quick sort
     * @param data
     * @param numRun
     */

    public static void timeQuickSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        
        // iterate through the loop numRun times
        for (int i = 0; i < numRun; i++) {
            // check the initial runtime
            startTime = System.currentTimeMillis();
            // call quick sort
            sort.QuickSort(data, 0, data.size() - 1);
            // check the current run time again and add it to total time
            totalTime += System.currentTimeMillis();
            // substract the total time to the start time
            totalTime -= startTime;
        }

        
        System.out.println();
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * check the run time for binary search
     * @param sortedData
     * @param toSearch
     * @param numRun
     */

    public static void timeBinarySearch(ArrayList<Integer> sortedData, ArrayList<Integer> toSearch, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        
        // iterate through the outer loop numRum times
        for (int i = 0; i < numRun; i++) {
            // record the initial run time and save it to star time
            startTime = System.currentTimeMillis();
            // iterate through the inner loop so that every integer in toSearch is searched
            for (int j = 0; j < toSearch.size(); j++) {
                binary.binarySearch(sortedData, 0, sortedData.size() - 1, toSearch.get(j));
            }
            // record the run time again
            totalTime += System.currentTimeMillis();
            // subtract the total time to the start tiem ot eliminate the overlapping time
            totalTime -= startTime;
        }

        
        System.out.println();
        System.out.println("Benchmarking Binary Search on sorted array: ");
        System.out.println("Number of data in sorted array: " + sortedData.size());
        System.out.println("Number of data to search: " + toSearch.size());
        System.out.println("Average time taken to search: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * check the run time for linear search
     * @param sortedData
     * @param toSearch
     * @param numRun
     */

    public static void timeLinearSearch(ArrayList<Integer> sortedData, ArrayList<Integer> toSearch, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        
        // iterate the outer loop numRun times
        for (int k = 0; k < numRun; k++) {
            // record the initial run time
            startTime = System.currentTimeMillis();
            // iterate the inner loop to complete linear search
            for (int i = 0; i < toSearch.size(); i++) {
                // go through every sorted data
                for (int j = 0; j < sortedData.size(); j++) {
                    // stop the inner inner loop if sortedData at j equals toSearch at i
                    if (toSearch.get(i).compareTo(sortedData.get(j)) == 0) {
                        break;
                    }
                }
            }
            // add the currrent run time to total time
            totalTime += System.currentTimeMillis();
            // get rid of overlapping tiem
            totalTime -= startTime;
        }

        
        System.out.println();
        System.out.println("Benchmarking Linear Search on sorted array: ");
        System.out.println("Number of data in sorted array: " + sortedData.size());
        System.out.println("Number of data to search: " + toSearch.size());
        System.out.println("Average time taken to search: " + totalTime / numRun + " ms");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> toSearch = randomNumbers(NUM_SEARCH, MIN, MAX);
        int numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            Sorts<Integer> sorts = new Sorts<>();
            sorts.QuickSort(data, 0, data.size() - 1);
            timeBinarySearch(data, toSearch, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            Sorts<Integer> sorts = new Sorts<>();
            sorts.QuickSort(data, 0, data.size() - 1);
            timeLinearSearch(data, toSearch, 1);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeQuickSort(data, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeMergeSort(data, NUM_RUN);
            numData += numData;
        }

        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX);
            timeInsertionSort(data, 1);
            numData += numData;
        }
    }


}
