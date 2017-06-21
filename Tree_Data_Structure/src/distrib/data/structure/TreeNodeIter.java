package distrib.data.structure;

import java.util.Iterator;
/**
 * Iterator implementation for Tree research
 * @author Anthony Paulin
 * @version 0.1
 * @since 07-06-17
 * @category data process
 * 
 * @param <S> tree node
 */
public final class TreeNodeIter<S> implements Iterator<TreeNode<S>> {
	enum ProcessStages {
		ProcessParent, ProcessChildCurNode, ProcessChildSubNode
	}

	private TreeNode<S> treeNode;//The tree node to check

	/**
	 * 
	 * @param treeNode the tree node to check
	 */
	public TreeNodeIter(TreeNode<S> treeNode) {
		super();
		this.treeNode = treeNode;
		this.doNext = ProcessStages.ProcessParent;
		this.childrenCurNodeIter = treeNode.getChildren().iterator();
	}

	private ProcessStages doNext;//What process stage
	private TreeNode<S> next;//Next tree node
	private Iterator<TreeNode<S>> childrenCurNodeIter;
	private Iterator<TreeNode<S>> childrenSubNodeIter;

	/**
	 * check if the node has next
	 */
	@Override
	public boolean hasNext() {
		if (this.doNext == ProcessStages.ProcessParent) {
			this.next = this.treeNode;
			this.doNext = ProcessStages.ProcessChildCurNode;
			return true;
		}

		if (this.doNext == ProcessStages.ProcessChildCurNode) {
			if (childrenCurNodeIter.hasNext()) {
				TreeNode<S> childDirect = childrenCurNodeIter.next();
				childrenSubNodeIter = childDirect.iterator();
				this.doNext = ProcessStages.ProcessChildSubNode;
				return hasNext();
			} else {
				this.doNext = null;
				return false;
			}
		}

		if (this.doNext == ProcessStages.ProcessChildSubNode) {
			if (childrenSubNodeIter.hasNext()) {
				this.next = childrenSubNodeIter.next();
				return true;
			} else {
				this.next = null;
				this.doNext = ProcessStages.ProcessChildCurNode;
				return hasNext();
			}
		}
		return false;
	}

	@Override
	public TreeNode<S> next() {
		return this.next;
	}
}
