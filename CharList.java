import java.lang.*;
import java.util.ArrayList;

public class CharList {

	private char[] allChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
	       'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
		'v', 'w', 'x', 'y', 'z'};
	private ArrayList<Node> list;
	private long totalLetters;

	public CharList () {
		list = new ArrayList<>();
		for (char c : allChar) {
			list.add(new Node(c));
		}
		totalLetters = 0;
	}

	public void findAndIncrement (char c) {
		for (Node n : list) {
			if (n.getCharacter() == c) {
				n.increaseCount();
				totalLetters++;
			}
		}
	}

	public long getTotalLetters () {
		return totalLetters;
	}

	public double percentage (long letterCount) {
		return (double) letterCount / totalLetters;
	}

	public ArrayList<Node> getList () {
		return list;
	}

	public void printResults () {
		System.out.println("Results");
		System.out.println("---------------");
		for (Node n : list) {
			System.out.println(n.getCharacter() + ": " + n.getCount() + " " + percentage(n.getCount()) + "%");
		}
	}

	protected class Node {
		 /*
		  * Instance Variables
		  */
		private char character;
		private long count;
		
		public Node (char pCharacter) {
			character = pCharacter;
			count = 0;
		}

		public char getCharacter () {
		       return character;
		}

		public long getCount () {
			return count;	
		}

		public void increaseCount() {
			count++;
		}
	}
}
