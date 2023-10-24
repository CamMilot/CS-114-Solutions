import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Anagrams {

    public static void main(String[] args) {
        List<wordPair> wordList;
        wordList = new ArrayList<wordPair>();
        File file = new File("txt/words.txt");
        // File file = new File("../resource/asnlib/public/words.txt");

        Scanner in = new Scanner(System.in);
        wordPair a = new wordPair(in.nextLine());
        String b = a.getSorted();
        System.out.println(b);
        in.close();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.next();
                wordPair bc = new wordPair(line);
                if (bc.getSorted().equals(b)) {
                    System.out.println(bc.getUnsorted());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
