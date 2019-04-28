/*
 * NAME: Zhaoyi Guo
 * PID: A15180402
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Dictionary Count implementation
 * find out the top three most common characters in a text file
 *
 */
public class DictionaryCount {

    /**
     * This method would read all the words from the given file and store them into
     * an ArrayList of Pairs, where each of the pair contains a word and count as 0.
     *
     * @param fileName the given file to be read
     * @return an ArrayList containing pairs storing all the words from the given file
     */


    private static ArrayList<Pair> readDict(String fileName) {

        try {
            ArrayList<Pair> pairs = new ArrayList<>();
            Scanner sc = new Scanner(new File(fileName));

            // read numWords or readAll from the given file
            while(sc.hasNext()) {
                pairs.add(new Pair(sc.next()));
            }
            sc.close();
            return pairs;
        }
        catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    /**
     * This method would read all the words from the given file and store them into
     * an ArrayList of Strings.
     *
     * @param fileName the given file to be read
     * @return an ArrayList containing all the words from the given file
     */
    private static ArrayList<String> readWords(String fileName) {

        try {
            ArrayList<String> words = new ArrayList<>();
            Scanner sc = new Scanner(new File(fileName));

            // read numWords or readAll from the given file
            while (sc.hasNext()) {
                words.add(sc.next());
            }
            sc.close();
            return words;
        }
        catch (IOException e) {
            System.out.println("File not found!");
            return null;
        }
    }

    /**
     * This method takes in a dictionary, and it returns this dictionary
     * with sorted orders, so we can use binary serach on this dictionary.
     *
     * @param pairs
     * @return sorted pairs
     */
    public static ArrayList<Pair> populateDict(ArrayList<Pair> pairs) {
        // create a new sort() object, and use this object to call quicksort,
        // which is the fastest sort method.
        Sorts sort = new Sorts();
        sort.QuickSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    /**
     * This method takes in a dictionary, and serach one key from the element
     * @param dict
     * @param toSearch
     * @return true if toSearch is found in dict, false, otherwise
     */
    public static boolean searchDict(ArrayList<Pair> dict, String toSearch) {
        
        // create a new binarysearch object, and use binaryserach
        // to search for the key in the dictionary
        BinarySearch<Pair> bs = new BinarySearch<>();
        Integer index = bs.binarySearch(dict, 0, dict.size() - 1, new Pair(toSearch));
        if (index == null) {
            return false;
        }
        // increment the count of the pair if toSearch is found at a true index
        else {
            dict.get(index).incCount();
            return true;
        }
    }

    /**
     * this method combines the previous three method to count the number of occurances of each
     * characters listed in the dictionary.
     * @param args
     */

    public static void main(String[] args) {
        // find the dictionary array, and stores it into paris
        ArrayList<Pair> dictionary = readDict(args[0]);
        // find the testbook array
        ArrayList<String> textBook = readWords(args[1]);
        // sort the dictionary array of paris
        populateDict(dictionary);
        //iterate through the textbook array, and search if every single element of
        // the textbook array is in the dictionary
        for (int k = 0; k < textBook.size(); k++) {
            searchDict(dictionary, textBook.get(k));
        }
        //sort the dictionary again, but based on count, not on names
        Collections.sort(dictionary, new CountComp());
        //print out the top three most common characters listed in the dictionary
        System.out.println(dictionary.get(0).getWord());
        System.out.println(dictionary.get(1).getWord());
        System.out.println(dictionary.get(2).getWord());

    }
}
