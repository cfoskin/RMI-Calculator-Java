


import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Classname: Calculator
Comment: The remote interface.

*/

public interface Calculator extends Remote {
	double addNumbers(double x, double y) throws RemoteException;
	double subtractNumbers(double x, double y) throws RemoteException;
	double multiplyNumbers(double x, double y) throws RemoteException;
	double divideNumbers(double x, double y) throws RemoteException;
}