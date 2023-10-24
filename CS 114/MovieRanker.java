import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;

/* Starter code for PS8.
 */

public class MovieRanker {

	public static void main(String[] args) {
		// File file = new File("../resource/asnlib/publicdata/ratings.tsv");
		File file = new File("ratings.txt");

		ArrayList<MovieRating> rl = new ArrayList<MovieRating>();

		try {
			Scanner scanner = new Scanner(file, "UTF-8");
			int count = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				// System.out.println(line);
				String[] tkns = line.split("\\t"); // tabs separate tokens
				MovieRating nr = new MovieRating(tkns[0], tkns[1], tkns[2]);
				rl.add(nr);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int minVotes = 1;
		int numRecords = 1;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("Enter minimum vote threshold and number of records:");
			minVotes = input.nextInt();
			numRecords = input.nextInt() + 1;
			if (minVotes * numRecords == 0)
				break;
			long startTime = System.currentTimeMillis();
			MinHeap arm = new MinHeap<>();
			int armSize = 0;
			for (int x = 0; x < rl.size(); x++) {
				int currVotes = rl.get(x).getVotes();
				if (currVotes < minVotes) {
					continue;
				}
				if (armSize == numRecords) {
					arm.removeMin();
					arm.insert(rl.get(x));
					continue;
				}
				arm.insert(rl.get(x));
				armSize += 1;
			}
			ArrayList<MovieRating> out = new ArrayList<MovieRating>();
			for (int x = 0; x < armSize; x++) {
				out.add(arm.removeMin());
			}
			for (int x = armSize - 1; x > 0; x--) {
				System.out.println(out.get(x));
			}

			/*
			 * Fill in code to determine the top numRecords movies that have at least
			 * minVotes votes. For each record mr, in decreasing order of average rating,
			 * execute a System.out.println(mr).
			 * Do not sort the movie list!
			 */

			System.out.println();
			;
			long readTime = System.currentTimeMillis();
			System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
		}
	}
}
