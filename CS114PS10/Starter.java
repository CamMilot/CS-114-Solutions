import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        File file = new File("Incomes.txt");
        ArrayList<Integer> incomes = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        int quartiles = in.nextInt();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.next();
                incomes.add(Integer.parseInt(line));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        in.close();

        Sorts sorts = new Sorts();
        int length = (int) Math.ceil(incomes.size() / (quartiles * 1.0));
        for (int i = 1; i < quartiles; i++) {
            int quartile = sorts.kqselect(incomes, 0, incomes.size() - 1, i * length);
            System.out.println("Quartile " + i + ": " + quartile);
        }
    }
}