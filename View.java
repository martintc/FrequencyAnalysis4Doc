import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class View extends JFrame implements ActionListener {

	private JButton submitButton;
	private JTextField fileTextField;
	private JButton selectFileButton;

	public View () {
		
		JPanel centerPanel = new JPanel (new BorderLayout());

		fileTextField = new JTextField();
		centerPanel.add(fileTextField, BorderLayout.CENTER);
	
		selectFileButton = new JButton("Select File");
		centerPanel.add(selectFileButton, BorderLayout.EAST);
		selectFileButton.addActionListener(this);

		submitButton = new JButton("Submit for Analysis");
		submitButton.addActionListener(this);
		centerPanel.add(submitButton, BorderLayout.SOUTH);


		JLabel title = new JLabel("FrequencyAnalysis4Doc");
	
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		add(mainPanel);
		setVisible(true);
		setSize(500,100);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed (ActionEvent e) {
		String buttonPressed = e.getActionCommand();
		if (buttonPressed.equals("Submit for Analysis")) {
			String fileName = fileTextField.getText();
			try {
				analyze(fileName);
			} catch (FileNotFoundException ex) {
				System.err.println("Error");
				System.exit(-1);
			}
		} else if (buttonPressed.equals("Select File")) {
			String file = selectFile();
			fileTextField.setText(file);
		}
	}

	private String selectFile() {
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int x = fileChooser.showOpenDialog(null);
		if (x == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().getAbsolutePath();
		} else {
			return null;
		}
	}

	public void analyze (String pFileName) throws FileNotFoundException {
		Analyze analyze = new Analyze(pFileName);
		boolean successful = analyze.analyzeFile();
		if (successful) {
			String results = analyze.passResults();
			JOptionPane r = new JOptionPane();
			r.showMessageDialog(this, results);
		} else {
			// error code
		}
	}

}
