/* Simple binary tree class that includes methods to construct a
 * tree of ints, to print the structure, and to print the data
 * using a preorder, inorder or postorder traversal. The trees
 * built have nodes numbered starting with 1 and numbered
 * sequentially level by level with no gaps in the tree. The
 * documentation refers to these as "sequential trees."
 */

import java.util.*;

public class IntTree 
{
	private IntTreeNode overallRoot;

	// pre : max > 0   
	// post: constructs a sequential tree with given number of
	//       nodes
	public IntTree(int max) 
	{
		if (max <= 0) 
		{
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1, max);
	}

	// post: returns a sequential tree with n as its root unless
	//       n is greater than max, in which case it returns an
	//       empty tree
	private IntTreeNode buildTree(int n, int max) 
	{
		if (n > max) 
		{
			return null;
		} 

		else 
		{
			return new IntTreeNode(n, buildTree(2 * n, max),
					buildTree(2 * n + 1, max));
		}
	}

	// post: prints the tree contents using a preorder traversal
	public void printPreorder() 
	{
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}

	// post: prints the tree contents using a preorder traversal
	// post: prints in preorder the tree with given root
	private void printPreorder(IntTreeNode root)
	{
		if (root != null) 
		{
			System.out.print(" " + root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// post: prints the tree contents using a inorder traversal
	public void printInorder() 
	{
		System.out.print("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntTreeNode root)
	{
		if (root != null) 
		{
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}

	// post: prints the tree contents using a postorder traversal
	public void printPostorder() 
	{
		System.out.print("postorder:");
		printPostorder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the tree with given root
	private void printPostorder(IntTreeNode root) 
	{
		if (root != null)
		{
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" " + root.data);
		}
	}

	// post: prints the tree contents, one per line, following an
	//       inorder traversal and using indentation to indicate
	//       node depth; prints right to left so that it looks
	//       correct when the output is rotated.
	public void printSideways() 
	{
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	//       root, indenting each line to the given level
	private void printSideways(IntTreeNode root, int level)
	{
		if (root != null) 
		{
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) 
			{
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}

	/* Mohamed Elfergani
	 * CS 211
	 * 6/6/2021
	 * In this program we write a method called countLeftNodes that returns the number of 
	 * left children in the tree. A left child is a node that appears as the root of 
	 * the left-hand subtree of another node.
	 * 
	 * Chapter 17 Exercise 01
	 */

	public int countLeftNodes() 
	{
		return countLeftNodes(overallRoot);
	}

	// helper method
	private int countLeftNodes(IntTreeNode nodeN) 
	{
		// if the node is nothing, then return 0
		if(nodeN == null)
		{
			return 0;
		}

		// else if there is something in the left node then it is null
		else if(nodeN.left != null) 
		{
			// else if return then keeps going until the if-statement has reached the end 
			return 1 + countLeftNodes(nodeN.left) + countLeftNodes(nodeN.right);
		}

		// else return countLeftNodes of nodeN.right
		else 
		{
			return countLeftNodes(nodeN.right);
		}
	}

	/* Mohamed Elfergani
	 * CS 211
	 * 6/6/2021
	 * In this program we will write a Write a method called printLevel that accepts an 
	 * integer parameter n and prints the values at level n from left to right, one per line.
	 * We will use the convention that the overall root is at level 1, its children 
	 * are at level 2, and so on. If there are no values at the level, your method should produce 
	 * no output. Your method should throw an IllegalArgumentException if it is passed a value for 
	 * a level that is less than 1.
	 * 
	 * Chapter 17 Exercise 05
	 * 
	 */
	public void printLevel(int n) 
	{
		/* n is checked before going to the method and if it is 
		 * less than one it will throw an IllegalArgumentException
		 */
		if(n < 1) 
			throw new IllegalArgumentException();

		// if nothing happens then call the method on n
		printLevel(overallRoot, n);
	}

	// helper method
	private void printLevel(IntTreeNode myNodeRoot, int n) 
	{

		// if there's nothing in the node, then return
		if(myNodeRoot == null) 
			return;

		// if n is one then print the first root
		if(n == 1) 
		{
			// print output of the node.data
			System.out.println(myNodeRoot.data + " ");
			return;
		}

		// after root is printed out we go left and right through the tree to find the numbers
		printLevel(myNodeRoot.left, n - 1);
		printLevel(myNodeRoot.right, n - 1);
	}

	/* Mohamed Elfergani
	 * CS 211
	 * 6/6/2021
	 * In this program we write a Write a toString method for a binary tree of integers. 
	 * The method should return "empty" for an empty tree. For a leaf node, it should return
	 * the data in the node as a string. For a branch node, it should return a parenthesized 
	 * String that has three elements separated by commas: the data at the root, a string 
	 * representation of the left subtree, and then a string representation of the right subtree.
	 * 
	 * Chapter 17 Exercise 08
	 * 
	 */
	public String toString() 
	{
		return toString(overallRoot);
	}

	// helper method
	private String toString(IntTreeNode myNode) 
	{
		// if the tree does nothing then return an empty
		if(myNode == null)
		{
			return "empty";
		}

		/* this prints out the node if we have a root but 
		 * it does not print left or right of the tree.
		 * This also returns node.data
		 */
		else if(myNode.left == null && myNode.right == null) 
		{
			return "" + myNode.data;
		}

		/* else if traverse a left and a right through the tree 
		 * and we then call a toString
		 */
		else 
		{
			return "(" + myNode.data + ", " + toString(myNode.left) + ", " + 
					toString(myNode.right) + ")";
		}
	}
}
