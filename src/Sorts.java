/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import java.util.ArrayList;

/**
 * this class consists of insertion sort, merge sort, and quick sort
 * @param <T>
 */
public class Sorts<T extends Comparable<? super T>> {
    private int midrangeFactor = 2;

    /**
     * implement insertion sort
     * @param list
     * @param start
     * @param end
     */
    public void InsertionSort(ArrayList<T> list, int start, int end) {

        // get the number of element to sort at first
        int diff = end - start;
        // iterate diff
        for (int i = 1; i <= diff; i++) {
            int j = i;
            // compare the previous list element to the current list element
            // if the previous element is greater than the current element, swap them
            while (j > 0 && list.get(j + start - 1).compareTo(list.get(j + start)) > 0) {
                T temp = list.get(j + start);
                list.set(j + start, list.get(j + start - 1));
                list.set(j + start - 1, temp);
                // decrease j by 1, and maybe iterate the while loop again
                j--;
            }
        }
    }

    /**
     * implement merge sort
     * @param list
     * @param start
     * @param end
     */


    public void MergeSort(ArrayList<T> list, int start, int end) {

        // divide the list into half for faster sorting
        int j = 0;
        if (start < end) {
            j = (start + end) / midrangeFactor;
            // recursion call the first half of the list
            MergeSort(list, start, j);
            // recursion call the second half of the list
            MergeSort(list, j + 1, end);
            // merge the sorted part of the list together
            Merge(list, start, j, end);
        }
    }

    /**
     * helper method for MergeSort
     * @param list
     * @param i
     * @param j
     * @param k
     */
    public void Merge(ArrayList<T> list, int i, int j, int k) {
        // Size of merged partition
        int mergedSize = k - i + 1;
        // Position to insert merged number
        int mergePos = 0;
        // Position of elements in left partition
        int leftPos = 0;
        // Position of elements in right partition
        int rightPos = 0;
        // Dynamically allocates temporary array
        ArrayList<T> mergedNumbers = new ArrayList<>();
        // for merged numbers

        // Initialize left partition position
        leftPos = i;
        // Initialize right partition position
        rightPos = j + 1;

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            if (list.get(leftPos).compareTo(list.get(rightPos)) < 0) {
                mergedNumbers.add(list.get(leftPos));
                leftPos++;
            }
            else {
                mergedNumbers.add(list.get(rightPos));
                rightPos++;

            }
            mergePos++;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers.add(list.get(leftPos));
            leftPos++;
            mergePos++;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers.add(list.get(rightPos));
            rightPos++;
            mergePos++;
        }

        // Copy merge number back to numbers
        for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
            list.set(i + mergePos, mergedNumbers.get(mergePos));
        }
    }

    /**
     * implement quick sort
     * @param list
     * @param start
     * @param end
     */


    public void QuickSort(ArrayList<T> list, int start, int end) {

        // set j to zero
        int j = 0;

        // Base case: If there are 1 or zero elements to sort,
        // partition is already sorted
        if (start >= end) {
            return;
        }

        // Partition the data within the array. Value j returned
        // from partitioning is location of last element in low partition.
        j = partition(list, start, end);

        // Recursively sort low partition (start to j) and
        // high partition (j + 1 to end)
        QuickSort(list, start, j);
        QuickSort(list, j + 1, end);

    }

    /**
     * helper method for quick sort
     * @param list
     * @param i
     * @param k
     * @return h
     */
    public Integer partition(ArrayList<T> list, int i, int k) {
        int l = 0;
        int h = 0;
        int midpoint = 0;
        T pivot;
        T temp;
        boolean done = false;

        // Pick middle element as pivot
        midpoint = i + (k - i) / midrangeFactor;
        pivot = list.get(midpoint);

        l = i;
        h = k;

        while (!done) {

            // Increment l while numbers[l] < pivot
            while (list.get(l).compareTo(pivot) < 0) {
                l++;
            }

            // Decrement h while pivot < numbers[h]
            while (pivot.compareTo(list.get(h)) < 0) {
                h--;
            }

            // If there are zero or one elements remaining,
            // all numbers are partitioned. Return h
            if (l >= h) {
                done = true;
            }
            else {
                // Swap numbers[l] and numbers[h],
                // update l and h
                temp = list.get(l);
                list.set(l, list.get(h));
                list.set(h, temp);
                l++;
                h--;
            }
        }

        return h;
    }

}
