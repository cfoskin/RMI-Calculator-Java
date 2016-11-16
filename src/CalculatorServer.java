
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import gui.ServerGUI;

// If you don't run the rmiregistry application from the command line
// include the following import:
// import java.rmi.registry.LocateRegistry.Registry;

/*
Classname: CalculatorServer
Purpose: The RMI server.
*/

public class CalculatorServer extends UnicastRemoteObject implements Calculator {
	private ServerGUI serverGUI;

	public CalculatorServer() throws RemoteException {
		super();
		serverGUI = new ServerGUI();
		try {
			Naming.rebind("Calculator", this);
			serverGUI.jta.append("Calculator bound in registry \n");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void displayInfo(double x, double y, double total, String operator){
		serverGUI.jta.append("First value: "+ x + "\n");
		serverGUI.jta.append("Second value: "+ y + "\n");
		serverGUI.jta.append("Operator value: " + operator + " \n");
		serverGUI.jta.append("Total value: "+ total + "\n");
	}

	public double addNumbers(double x, double y) throws RemoteException {
		double total = x + y;
		displayInfo(x, y, total, "+");
		return total;
	}

	@Override
	public double subtractNumbers(double x, double y) throws RemoteException {
		double total = x - y;
		displayInfo(x, y, total, "-");
		return total;
	}

	@Override
	public double multiplyNumbers(double x, double y) throws RemoteException {
		double total = x * y;
		displayInfo(x, y, total, "*");
		return total;
	}

	@Override
	public double divideNumbers(double x, double y) throws RemoteException {
		double total = x / y;
		displayInfo(x, y, total, "/");
		return total;
	}

	public static void main(String args[]) {
		try {
			CalculatorServer obj = new CalculatorServer();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
	}

}