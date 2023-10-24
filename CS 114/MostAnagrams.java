import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MostAnagrams {

    public static void main(String[] args) {

        List<wordPair> wordList;
        List<String> sorted;
        wordList = new ArrayList<wordPair>();
        sorted = new ArrayList<String>();
        // File file = new File("../resource/asnlib/publicdata/words.txt");
        File file = new File("txt/words.txt");

        Scanner in = new Scanner(System.in);
        int a = Integer.parseInt(in.nextLine());
        in.close();
        int max = 0;
        int curr = 0;
        try {
            Scanner scanner = new Scanner(file);
            for (int x = 1; x < a; x++) {
                System.out.println("here");
                String line = scanner.next();
                wordList.add(new wordPair(line));
                String arr = wordList.get(curr).sortedWord;
                sorted.add(arr);
                if (sorted.get(0).length() != 6) {
                    a--;
                    continue;
                }
                int first = sorted.indexOf(arr);
                if (first < curr && first >= 0) {
                    wordList.get(first).incVal();
                    if (wordList.get(first).a > max) {
                        max = (wordList.get(first).a);
                    }

                }
                // read in the next word
                // Now do something with the word
                //
                curr++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // compute max, the maximum number of analgrams for any word

        System.out.println(max);

    }
}
