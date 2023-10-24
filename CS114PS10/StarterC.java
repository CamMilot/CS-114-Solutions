import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StarterC {

    public static void main(String[] args) {
        int size = 2622563;
        File file = new File("Incomes.txt");
        int[] incomes = new int[size];

        Scanner in = new Scanner(System.in);
        int quartiles = in.nextInt();

        try {
            Scanner scanner = new Scanner(file);
            int x = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                incomes[x] = (Integer.parseInt(line));
                x++;
            }
            size = x;
            System.out.println(x);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        in.close();

        Select sorts = new Select();
        int length = (int) size / quartiles;
        for (int i = 1; i < quartiles; i++) {
            int quartile = sorts.select(incomes, 0, size, i * length);
            System.out.println("Quartile " + i + ": " + quartile);
        }

    }
}