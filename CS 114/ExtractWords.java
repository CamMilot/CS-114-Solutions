
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ExtractWords {

    public static ArrayList<String> wordList;
    public static ArrayList<String> returnList;

    public static void main(String[] args) {
        wordList = new ArrayList<String>();
        returnList = new ArrayList<String>();
        File file = new File("txt//words.txt");
        // File file = new File("../resource/asnlib/public/words.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.next();
                wordList.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        String all = in.nextLine();
        in.close();
        int a = 0;
        int b = all.length();
        if (extractWords(all, a, b)) {
            for (int i = returnList.size() - 1; i >= 0; i--) {
                if (i > 0) {
                    System.out.print(returnList.get(i) + " ");
                } else {
                    System.out.print(returnList.get(i));
                }
            }
        }

        else {
            System.out.print("null");
        }

        // System.out.println("time: "+(end-start));
    }

    public static Boolean extractWords(String thing, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (wordSearch(thing.substring(start, end))) {
            /*
             * System.out.println(start + " " + end);
             * System.out.print(thing.substring(start, end) + ' ');
             */
            returnList.add(thing.substring(start, end));
            return true;
        }
        for (int x = start; x < end; x++) {

            if (wordSearch(thing.substring(start, x))) {

                if (extractWords(thing, x, end)) {
                    /* System.out.println(thing.substring(start, x) + ' '); */
                    returnList.add(thing.substring(start, x));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return The index of an element in sorted list A with value k.
     *         If k is not in A,return -1.
     */
    public static boolean wordSearch(String word) {
        if (binarySearch(word, wordList) >= 0) {
            return true;
        }
        return false;

    }

    static <E extends Comparable<E>> int binarySearch(E s, List<E> A) {
        int l = -1; // Set l and r
        int r = A.size(); // beyond list bounds
        while (l + 1 != r) { // Stop when l, r meet
            int i = (l + r) / 2; // Check middle
            if (s.compareTo(A.get(i)) < 0)
                r = i; // In left half
            if (s.compareTo(A.get(i)) == 0)
                return i; // found it
            if (s.compareTo(A.get(i)) > 0)
                l = i; // In right half
        }
        return -1; // Search value not in List A
    }
}
