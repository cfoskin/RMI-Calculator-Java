
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Colum Foskin Calculator server which implements the Calculator
 *         interface. Creates a new instance of ServerGUI on start up.
 */
public class CalculatorServer extends UnicastRemoteObject implements Calculator {
	private ServerGUI serverGUI;

	/**
	 * Construct a new Server
	 * 
	 * @throws RemoteException
	 */
	public CalculatorServer() throws RemoteException {
		super();
		serverGUI = new ServerGUI();
	}

	/**
	 * Display the info on the server GUI test area
	 * 
	 * @param x
	 * @param y
	 * @param total
	 * @param operator
	 */
	private void displayInfo(double x, double y, double total, String operator) {
		try {
			serverGUI.jta.append("Client: " + this.getClientHost()+ "\n");
		} catch (ServerNotActiveException e) {
			serverGUI.jta.append("Could not get client ipaddress \n");
		}
		serverGUI.jta.append("First value: " + x + "\n");
		serverGUI.jta.append("Second value: " + y + "\n");
		serverGUI.jta.append("Operator value: " + operator + " \n");
		serverGUI.jta.append("Total value: " + total + "\n");
	}

	/**
	 * add two numbers
	 */
	@Override
	public double addNumbers(double x, double y) throws RemoteException {
		double total = x + y;
		displayInfo(x, y, total, "+");
		return total;
	}

	/**
	 * subtract two numbers
	 */
	@Override
	public double subtractNumbers(double x, double y) throws RemoteException {
		double total = x - y;
		displayInfo(x, y, total, "-");
		return total;
	}

	/**
	 * Multiply two numbers
	 */
	@Override
	public double multiplyNumbers(double x, double y) throws RemoteException {
		double total = x * y;
		displayInfo(x, y, total, "*");
		return total;
	}

	/**
	 * divide two numbers
	 */
	@Override
	public double divideNumbers(double x, double y) throws RemoteException {
		double total = x / y;
		displayInfo(x, y, total, "/");
		return total;
	}

	/**
	 * Main method to run app
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			CalculatorServer obj = new CalculatorServer();
			Naming.rebind("Calculator", obj);
			System.out.println("Calculator bound in registry");
		} catch (Exception e) {
			System.out.println("CalculatorServer error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}