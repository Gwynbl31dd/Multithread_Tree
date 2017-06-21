package distrib.data.structure;

/**
 * Structure of the Tree.
 * @author Anthony Paulin
 * @version 0.1
 * @since 08-06-17
 * @category Data Structure
 *
 */
public final class DataStructure {
	/**
	 * Generate a Tree Structure
	 * 
	 * @return Return the root node of the Tree (And its children)
	 */
	@SuppressWarnings("unused")
	public final static TreeNode<Data> getStructure() {
		TreeNode<Data> root = new TreeNode<Data>(new Data(1, 'R'));
		{
			TreeNode<Data> node0 = root.addChild(new Data(4, 'G'));
			{
				TreeNode<Data> node00 = node0.addChild(new Data(6, 'H'));
				TreeNode<Data> node01 = node0.addChild(new Data(10, 'E'));
			}

			TreeNode<Data> node1 = root.addChild(new Data(2, 'F'));
			{
				TreeNode<Data> node10 = node1.addChild(new Data(5, 'Z'));
				{
					TreeNode<Data> node100 = node10.addChild(new Data(3, 'X'));
				}
				TreeNode<Data> node11 = node1.addChild(new Data(7, 'P'));
				TreeNode<Data> node12 = node1.addChild(new Data(11, 'L'));
			}

			TreeNode<Data> node2 = root.addChild(new Data(8, 'Q'));
			{
				TreeNode<Data> node20 = node2.addChild(new Data(9, 'U'));
				{
					TreeNode<Data> node200 = node20.addChild(new Data(12, 'T'));
					TreeNode<Data> node201 = node20.addChild(new Data(13, 'D'));
				}
			}
		}
		return root;
	}
}
