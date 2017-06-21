package distrib.data;

import distrib.data.structure.Data;

/**
 * Class used to compare values
 * @author Anthony Paulin
 * @since 08-06-17
 * @version 0.1
 * @category utility
 *
 */
public class Comparator implements Comparable<Data> {
	private int numberCompare;
	
	/**
	 * 
	 * @param numberCompare the number to compare
	 */
	public Comparator(int numberCompare) {
		this.numberCompare = numberCompare;
	}

	/**
	 * Compare the number given with the number in the tree data
	 */
	@Override
	public int compareTo(Data treeData) {
		if (treeData == null)
			return 1;
		if (treeData.getNumber() == this.numberCompare)
			return 0;
		else
			return 1;
	}

}
