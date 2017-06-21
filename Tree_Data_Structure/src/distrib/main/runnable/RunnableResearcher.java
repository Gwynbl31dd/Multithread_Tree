package distrib.main.runnable;

import distrib.data.structure.TreeNode;
import distrib.main.Main;

/**
 * Thread used to research in the tree
 * @author Anthony Paulin
 * @version 0.1
 * @since 08-06-17
 * @param <S>
 *
 */
public final class RunnableResearcher<S> implements Runnable {
	private Comparable<S> cmp;
	private TreeNode<S> element;
	/**
	 * 
	 * @param cmp Comparable
	 * @param element the element to compare
	 */
	public RunnableResearcher(Comparable<S> cmp, TreeNode<S> element) {
		super();
		this.cmp = cmp;
		this.element = element;
	}
	
	/**
	 * Research recursively using a Thread into the tree
	 */
	@Override
	public void run() {
		S elData = element.getData();//Get the node data
		if (cmp.compareTo(elData) == 0) {
			Main.setInProgress(false);//If the result is found, stop all thread
			// Print the result
			System.out.println("Found :" + element.getData());
		} else if (element.getChildren().isEmpty() == false) {
			
			for (int i = 0; i < element.getChildren().size() && Main.isInProgress() == true; i++) {
				Thread threadResearch = new Thread(new RunnableResearcher<S>(cmp, element.getChildren().get(i)));
				threadResearch.start();//Start another Thread
				
			}
		}
	}
}