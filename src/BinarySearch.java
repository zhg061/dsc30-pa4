/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import java.util.ArrayList;

/**
 * Binary search implementation
 *
 * @author Zhaoyi Guo
 * @since 4/25/19
 */
public class BinarySearch<T extends Comparable<? super T>> {
    private int midrangeFactor = 2;

    /**
     * this method searches for the key in the list, and return the index of the key
     *
     * @param sortedList
     * @param start
     * @param end
     * @param toSearch
     * @return the index of toSearch in the sortedList, null if not found
     */
    public Integer binarySearch(ArrayList<T> sortedList, int start, int end, T toSearch) {
        // This method takes in an array list, start index, ennd index, and the key to search
        int mid = 0;
        int low = start;
        int high = end;

        while (high >= low) {
            mid = (high + low) / midrangeFactor;
            // If the middle element is smaller than the key, the search range changes to the
            // second half of the array
            if (sortedList.get(mid).compareTo(toSearch) < 0) {
                low = mid + 1;
            }
            // If the middle element is larger than the key, the search range changes to the
            // first half of the array
            else if (sortedList.get(mid).compareTo(toSearch) > 0) {
                high = mid - 1;
            }
            // if the middle value equals to the key, the index of the middle element return
            else if (sortedList.get(mid).compareTo(toSearch) == 0) {
                return mid;
            }
        }

        return null; // not found
    }

}
