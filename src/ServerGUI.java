
import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Colum Foskin - GUI for the server
 *
 */
public class ServerGUI {

	JFrame f;
	public JTextArea jta = new JTextArea();

	public ServerGUI() {
		initialize();
		this.f.setVisible(true);
	}

	/**
	 * initalize the GUI
	 */
	private void initialize() {
		f = new JFrame();
		f.setBounds(120, 120, 450, 350);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new JScrollPane(jta), BorderLayout.CENTER);
		f.setTitle("Server");
		jta.append("Server started on " + new Date() + '\n');
	}
}
