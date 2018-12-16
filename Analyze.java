import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Analyze {
	
	/*
	 * Instance Variables
	 */

	private CharList charList;
	private Scanner in;

	/*
	 * Constructors
	 */
	public Analyze (String pFileName) throws FileNotFoundException {
		charList = new CharList();
		in = new Scanner (new File(pFileName));
	}

	public boolean analyzeFile () throws FileNotFoundException {
		while (in.hasNextLine()) {
			String line = in.nextLine();
			line.toLowerCase();
			line.trim();
			char[] letters = line.toCharArray();
			for (char c : letters) {
				charList.findAndIncrement(c);
			}
		}
		in.close();
		return true;
	}

	public void getResults () {
		charList.printResults();
	}

}
