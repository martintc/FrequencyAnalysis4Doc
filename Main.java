import java.lang.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main (String[] args) throws FileNotFoundException {
        Main main = new Main();
        if (args.length == 0) {
		main.run();
	} else if (args.length != 0) {
		main.guiRun();
	}
    }

    public void run () throws FileNotFoundException {
        String fileName;
        Scanner in = new Scanner(System.in);
        System.out.println("Frequency Analysis \n" +
                "-----------------------------\n" +
                "Enter a file name: ");
        fileName = in.nextLine();

        Analyze analyze = new Analyze(fileName);
        boolean sucessful = analyze.analyzeFile();
        if (sucessful) {
            analyze.getResults();
        } else {
            System.out.println("Error occured!");
            System.exit(-1);
        }
    }

	public void guiRun() {
		View view = new View();
	}

}
