
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 
 * @author Colum Foskin The CalculatorClient class which acts as the RMI client.
 *         This class calls a new GUI for the client on start up. The GUI is a
 *         seperate class called ClientGUI
 */
public class CalculatorClient {
	static String message = "blank";
	static double total = 0; // the total of calculating the two operands
	ClientGUI clientGui; // the client gui
	private String fullInput = ""; // the current input for an operand
	private String currentOperator;// the current operator
	private boolean isOperatorLastInput = false;// used to check if the operator
												// was pressed previously
	private String arrayOfInputs[] = new String[2]; // store the inputs
	static Calculator obj = null;

	/**
	 * Create a new client
	 */
	public CalculatorClient() {
		clientGui = new ClientGUI();
		addListeners();
		try {

		} catch (Exception e) {
			clientGui.systemMessageJta.append("Calculator exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Main method to start the app
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		new CalculatorClient();
	}

	/**
	 * Checks an input - inputted by the client and handles it based on whether
	 * it is an operator or an operand.
	 * 
	 * @param input
	 *            - the input taken in from the GUI
	 */
	private void checkInput(String input) {
		if (!checkIfOperator(input)) {
			clientGui.dataInputJta.append(input);
			this.fullInput += input;
		} else {
			if (!isOperatorLastInput) {
				this.currentOperator = input;
				clientGui.dataInputJta.append(input);
				this.arrayOfInputs[0] = this.fullInput;
				this.fullInput = "";
				isOperatorLastInput = true;
			} else {
				clientGui.systemMessageJta.append("You cannot enter two operators in a row!");
				this.fullInput = "";
			}
		}
	}

	/**
	 * Submit button is pressed so handle inputs, call the doCalculation()
	 * method and then reset the array of inputs and current operators
	 */
	private void submit() {
		this.arrayOfInputs[1] = this.fullInput;
		isOperatorLastInput = false;
		doCalculation();
		clientGui.dataInputJta.setText("");
		this.currentOperator = "";
		this.fullInput = "";
		this.arrayOfInputs[0] = null;
		this.arrayOfInputs[1] = null;
	}

	/**
	 * perform a calcluation by invoking the correct method based on the current
	 * operator.
	 */
	private void doCalculation() {
		double x = Double.valueOf(this.arrayOfInputs[0]);
		double y = Double.valueOf(this.arrayOfInputs[1]);
		try {
			obj = (Calculator) Naming.lookup("//" + "localhost" + "/Calculator");
			switch (this.currentOperator) {
			case "+":
				total = obj.addNumbers(x, y);
				break;
			case "-":
				total = obj.subtractNumbers(x, y);
				break;
			case "*":
				total = obj.multiplyNumbers(x, y);
				break;
			case "/":
				total = obj.divideNumbers(x, y);
				break;
			default:
				break;
			}
			clientGui.systemMessageJta.setText(String.valueOf(total));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			clientGui.systemMessageJta.append("Calculator exception: " + e.getMessage());
		}
	}

	/**
	 * check is the input is an operator and return true or false
	 * 
	 * @param input
	 * @return
	 */
	private boolean checkIfOperator(String input) {
		boolean result = false;
		String[] operators = { "+", "-", "/", "*" };
		for (int i = 0; i < operators.length; i++) {
			if (operators[i] == input) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * add action listeners to the GUI
	 */
	private void addListeners() {
		clientGui.button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("0");
			}
		});

		clientGui.button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("1");
			}
		});

		clientGui.button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("2");
			}
		});

		clientGui.button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("3");
			}
		});

		clientGui.button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("4");
			}
		});

		clientGui.button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("5");
			}
		});

		clientGui.button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("6");
			}
		});

		clientGui.button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("7");
			}
		});

		clientGui.button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("8");
			}
		});

		clientGui.button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("9");
			}
		});

		clientGui.buttonDivide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("/");
			}
		});

		clientGui.buttonMultiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("*");
			}
		});

		clientGui.buttonPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("+");
			}
		});

		clientGui.buttonSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});

		clientGui.buttonSubtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkInput("-");
			}
		});
	}

}