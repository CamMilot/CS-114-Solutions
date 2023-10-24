import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pronunciation {
	private String word;
	private String pronounce;
	private List<String> wordList = new ArrayList<String>();

	Pronunciation(String p) {
		int i = p.indexOf(' ');
		word = p.substring(0, i);
		wordList.add(word);
		pronounce = p.substring(i + 1);
	}

	public String getWord() {
		return word;
	}

	public Integer leng() {
		return wordList.size();
	}

	public List<String> getWordList() {
		return wordList;
	}

	public String getPhonemes() {
		return pronounce;
	}

	public void addWord(String p) {
		wordList.add(p);
	}

	public List<String> retv() {
		return wordList;
	}
}