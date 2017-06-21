package distrib.data.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Nodes of the Tree
 * @author Anthony Paulin <paulin.anthony@gmail.com>
 * @version 0.1
 * @since 08-06-17
 * @category Data Structure
 * @param <S>  The node's data
 */
public final class TreeNode<S> implements Iterable<TreeNode<S>> {
	private S data;// The leaf's data
	private TreeNode<S> parent;// Leaf's parent's node
	private List<TreeNode<S>> children;// Leaf's children nodes
	private List<TreeNode<S>> elementsIndex;// Leaf's index

	/**
	 * 
	 * @param data the TreeNode Data
	 */
	public TreeNode(S data) {
		this.data = data;
		this.children = new LinkedList<TreeNode<S>>();
		this.elementsIndex = new LinkedList<TreeNode<S>>();
		this.elementsIndex.add(this);
	}

	/**
	 * 
	 * @return the children's node
	 */
	public final List<TreeNode<S>> getChildren() {
		return children;
	}

	/**
	 * 
	 * @return the leaf's data
	 */
	public final S getData() {
		return data;
	}

	/**
	 * 
	 * @return if no parents
	 */
	public final boolean isRoot() {
		return parent == null;
	}

	/**
	 * 
	 * @return is it a leaf
	 */
	public final boolean isLeaf() {
		return children.size() == 0;
	}

	/**
	 * Set the nodes children
	 * 
	 * @param child the child node
	 * @return the child node
	 */
	public final TreeNode<S> addChild(S child) {
		TreeNode<S> childNode = new TreeNode<S>(child);
		childNode.parent = this;
		this.children.add(childNode);
		this.registerChildForSearch(childNode);
		return childNode;
	}

	/**
	 * Return the level of the tree branch
	 * 
	 * @return The node's level
	 */
	public final int getLevel() {
		if (this.isRoot())
			return 0;
		else
			return parent.getLevel() + 1;
	}

	/**
	 * Register the child for search
	 * 
	 * @param node the node to register to his parent
	 */
	private final void registerChildForSearch(TreeNode<S> node) {
		elementsIndex.add(node);
		if (parent != null)
			parent.registerChildForSearch(node);
	}

	/**
	 * Return the toString method of the node's data
	 */
	@Override
	public final String toString() {
		return data != null ? data.toString() : "[data null]";
	}

	/**
	 * Get the iterator
	 */
	@Override
	public final Iterator<TreeNode<S>> iterator() {
		TreeNodeIter<S> iter = new TreeNodeIter<S>(this);
		return iter;
	}

}
