
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gui.ClientGUI;

/*
Classname: CalculatorClient
Comment: The RMI client.
*/

public class CalculatorClient {

	static String message = "blank";
	static double total = 0;
	ClientGUI clientGui;
	private String fullInput = "";
	private String currentOperator;
	private boolean isOperatorLastInput = false;
	private String arrayOfInputs[] = new String[2];
	// The Calculator object "obj" is the identifier that is
	// used to refer to the remote object that implements
	// the Calculator interface.

	static Calculator obj = null;

	public CalculatorClient() {
		clientGui = new ClientGUI();
		addListeners();
		try {

		} catch (Exception e) {
			clientGui.systemMessageJta.append("Calculator exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new CalculatorClient();
	}

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

		clientGui.buttonClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// clear();
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