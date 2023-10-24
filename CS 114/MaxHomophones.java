
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxHomophones {

    public static void main(String[] args) {
        // OALDictionary<String, Pronunciation> PDict = new OALDictionary<String,
        // Pronunciation>();
        UALDictionary<Integer, Pronunciation> PDict = new UALDictionary<Integer, Pronunciation>();
        List<String> Track = new ArrayList<>();
        File file = new File("cmudict.0.7a.txt");
        try {
            // File file = new File("../resource/asnlib/publicdata/cmudict.0.7a.txt");
            Scanner in = new Scanner(System.in);
            String goal = new String();
            Scanner scanner = new Scanner(file);
            int curr = 0;
            int max = 0;
            String goalPheno = "";
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.substring(0, 3).equals(";;;")) {
                    continue; // skip comment lines
                }
                Pronunciation p = new Pronunciation(line);
                Track.add(p.getWord());
                PDict.insert(curr, p);
                curr += 1;
            }
            boolean fun = true;

            while (fun) {

                goal = in.nextLine().toUpperCase();
                if (goal.equals(".")) {
                    fun = false;
                }
                boolean none = true;
                int ind = Track.indexOf(goal);
                // System.out.println(ind);
                goalPheno = PDict.find(ind).getPhonemes();
                Iterator<Pronunciation> go = PDict.values().iterator();
                while (go.hasNext()) {
                    Pronunciation currPro = go.next();
                    if (currPro.getPhonemes().equals(goalPheno) && !currPro.getWord().equals(goal)) {
                        System.out.println(currPro.getWord());
                        none = false;
                    }
                }
                if (none) {
                    System.out.println("No Homophones");
                }
                System.out.println("");

            }
            in.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
