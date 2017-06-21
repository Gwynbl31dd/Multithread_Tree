package distrib.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import distrib.data.Comparator;
import distrib.data.structure.Data;
import distrib.data.structure.DataStructure;
import distrib.data.structure.TreeNode;
import distrib.main.runnable.RunnableResearcher;

/**
 * Main Class of the program
 * @author Anthony Paulin 
 * @version 0.1
 * @since 08-06-17
 * @category Main software
 *
 */
public class Main {
	private static boolean inProgress = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberCompare = 0;
		System.out.println("******Tree multiThread Structure**************");
		System.out.println("*Press 0 to exit                             *");
		System.out.println("*Enter an interger to get the value          *");
		System.out.println("**********************************************");
		
		do {
			try {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				numberCompare = sc.nextInt();

				Comparator searchCriteria = new Comparator(numberCompare);

				// Get the Data structure for the Tree.
				TreeNode<Data> treeRoot = DataStructure.getStructure();

				inProgress = true;
				Thread threadResearch = new Thread(new RunnableResearcher<Data>(searchCriteria, treeRoot));
				threadResearch.start();
			} catch (InputMismatchException e) {
				System.out.println("Error.You must use an integer.");
			}
		} while (numberCompare != 0);
		System.exit(0);
	}

	/**
	 * Used to tell all the Thread the process is finished
	 * @return the state of the process
	 */
	public static synchronized boolean isInProgress() {
		return inProgress;
	}

	/**
	 * used to modify the state of the process
	 * @param inProgress the state of the process
	 */
	public static synchronized void setInProgress(boolean inProgress) {
		Main.inProgress = inProgress;
	}
}
