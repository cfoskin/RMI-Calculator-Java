
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextArea;

/**
 * 
 * @author Colum Foskin - GUI created for the client
 *
 */
public class ClientGUI {

	public JFrame frame;
	public JTextArea dataInputJta;
	public JButton buttonDivide, button7, button8, button9, buttonMultiply, button4, button5, button6, buttonSubtract,
			button1, button2, button3, buttonPlus, button0, buttonSubmit;
	public JTextArea systemMessageJta;

	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(31, 65, 285, 219);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 285, 52);
		panel_4.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		buttonDivide = new JButton("/");
		panel.add(buttonDivide);

		button7 = new JButton("7");
		panel.add(button7);

		button8 = new JButton("8");
		panel.add(button8);

		button9 = new JButton("9");
		panel.add(button9);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 57, 285, 52);
		panel_4.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		buttonMultiply = new JButton("*");
		panel_1.add(buttonMultiply);

		button4 = new JButton("4");
		panel_1.add(button4);

		button5 = new JButton("5");
		panel_1.add(button5);

		button6 = new JButton("6");
		panel_1.add(button6);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 111, 285, 52);
		panel_4.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		buttonSubtract = new JButton("-");
		panel_2.add(buttonSubtract);

		button1 = new JButton("1");
		panel_2.add(button1);

		button2 = new JButton("2");
		panel_2.add(button2);

		button3 = new JButton("3");
		panel_2.add(button3);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 164, 285, 52);
		panel_4.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));

		buttonPlus = new JButton("+");
		panel_3.add(buttonPlus);

		button0 = new JButton("0");
		panel_3.add(button0);
		
		buttonSubmit = new JButton("Submit");
		panel_3.add(buttonSubmit);

		dataInputJta = new JTextArea();
		dataInputJta.setBounds(31, 17, 285, 43);
		frame.getContentPane().add(dataInputJta);
		dataInputJta.setColumns(10);

		systemMessageJta = new JTextArea();
		systemMessageJta.setBounds(31, 296, 285, 55);
		frame.getContentPane().add(systemMessageJta);

	}
}
