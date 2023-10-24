import java.util.LinkedList;
import java.util.Scanner;

public class MovieRating implements Comparable<MovieRating> {
	private int votes;
	private int rating;
	private String title;

	MovieRating(String v, String r, String t) {
		votes = Integer.parseInt(v);
		rating = Integer.parseInt(r);
		title = t;
	}

	public int getVotes() {
		return votes;
	}

	public int getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public String toString() {
		int length = 10 - Integer.toString(votes).length() - 1 - Integer.toString(rating).length();
		String Spaces = " ";
		for (int x = 0; x < length; x++) {
			Spaces = Spaces + " ";
		}
		String s = Integer.toString(votes) + Spaces +
				Integer.toString(rating) + "      " + title;
		return s;
	}

	public int compareTo(MovieRating m) {
		if (this.rating > m.rating)
			return 1;
		else if (this.rating < m.rating)
			return -1;
		else if (this.rating == m.rating && this.title.compareTo(m.title) > 0)
			return -1;
		else if (this.rating == m.rating && this.title.compareTo(m.title) < 0)
			return 1;
		else
			return 0;
	}
}
