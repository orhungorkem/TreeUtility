import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class General {
	
	/**
	 * Root: Top of the tree
	 * Leaves(Terminal nodes): Nodes that have no children
	 * Depth: Levels in a tree. Root:0
	 * Height: The length of the longest path to a node from a leaf
	 * Height of the tree: The length of the longest path from the root to a leaf
	 * Balanced Tree: The difference between the height of the left and right subtrees is not more than 1
	 */
	
	
	/**
	 * DEPTH FIRST SEARCH(DFS) CAN BE IMPLEMENTED BY PREORDER/INORDER/POSTORDER TRAVERSALS
	 */
	
	
	public static void preOrder(BinaryTreeNode node) {
		if(node!=null) {
			System.out.print(node.value+" ");
			if(node.left!=null)
				preOrder(node.left);
			if(node.right!=null)
				preOrder(node.right);
		}
	}
	
	public static void inOrder(BinaryTreeNode node) {
		if(node!=null) {
			if(node.left!=null)
				inOrder(node.left);
			System.out.print(node.value+" ");
			if(node.right!=null)
				inOrder(node.right);
		}
	}
	
	public static void postOrder(BinaryTreeNode node) {
		if(node!=null) {
			if(node.left!=null)
				postOrder(node.left);
			if(node.right!=null)
				postOrder(node.right);
			System.out.print(node.value+" ");
		}
	}
	
	/**
	 * BFS PROCESSES TREE LEVEL BY LEVEL
	 */
	
	public static void bfs(BinaryTreeNode node) {
		Queue<BinaryTreeNode>q=new LinkedList<BinaryTreeNode>();
		q.add(node);
		while(!q.isEmpty()) {
			BinaryTreeNode cur=q.poll();
			System.out.print(cur.value+" ");
			if(cur.left!=null) {
				q.add(cur.left);
			}
			if(cur.right!=null) {
				q.add(cur.right);
			}
		}
	}
	
	public static void bfsBalances(BinaryTreeNode node) {
		Queue<BinaryTreeNode>q=new LinkedList<BinaryTreeNode>();
		q.add(node);
		while(!q.isEmpty()) {
			BinaryTreeNode cur=q.poll();
			System.out.print(cur.balanceFactor+" ");
			if(cur.left!=null) {
				q.add(cur.left);
			}
			if(cur.right!=null) {
				q.add(cur.right);
			}
		}
	}
	
	public static void bfsHeights(BinaryTreeNode node) {
		Queue<BinaryTreeNode>q=new LinkedList<BinaryTreeNode>();
		q.add(node);
		while(!q.isEmpty()) {
			BinaryTreeNode cur=q.poll();
			System.out.print(cur.height+" ");
			if(cur.left!=null) {
				q.add(cur.left);
			}
			if(cur.right!=null) {
				q.add(cur.right);
			}
		}
	}
	
	public static void dfsNonRecursive(BinaryTreeNode node) {  //PREORDER WITH STACK
		
		Stack<BinaryTreeNode>s=new Stack<BinaryTreeNode>();
		s.push(node);
		while(!s.isEmpty()) {
			BinaryTreeNode cur=s.pop();
			System.out.print(cur.value+" ");
			if(cur.right!=null) {
				s.push(cur.right);
			}
			if(cur.left!=null) {
				s.push(cur.left);
			}
		}
		
	}
	
	
	/**
	 * Radix searching: Examines the search keys one bit at time.
	 * -Digital Search Trees
	 * -Radix Search Trees
	 * -Multiway Radix Searching
	 */
	
	/**
	 * Digital search trees are similar to BST
	 * But branch by comparing key's bits, not the key as a whole.
	 * Equal keys must be avoided.
	 * Worst case is better than BST, depends on leading bits. If elements have b bit keys, b comparisons is the worst case.
	 * 11011 00110 example keys, in a dst, longest path has length 5.
	 */

	/**
	 * Radix search trees do not store the keys in the tree.
	 * Therefore,more efficient for nodes with long keys.
	 * Internal nodes: Contain only links to other nodes. External nodes: Contain keys, no links.
	 * To insert a key,
	 * 		-go along the path described by bit pattern
	 * 		-when an external node reached, if is empty, store the new key as an external node.
	 * 		-if not empty, replace it with an internal node
	 * 		-link the node to the new and old key(if they have equal bits, keep putting internal nodes)
	 * To make a search, just branch the bits till coming to an external node, compare the keys.(Just one comparison)
	 */
	
	/**
	 * Height of a tree is limited by its bits so with larger keys, height increases.
	 * To overcome this, multiway radix trees are used.
	 * Branching is according to 2 bits generally.(00,01,10,11)
	 * If m bits are examined at a time, speed increases 2^m
	 * But nodes will have 2^m links which wastes space.
	 */
	
	
	
	
	
	

	public static void main(String[] args) {
		/*
		BinaryTreeNode root=new BinaryTreeNode(1);
		root.left=new BinaryTreeNode(2);
		root.right=new BinaryTreeNode(3);
		root.left.left=new BinaryTreeNode(4);
		root.left.right=new BinaryTreeNode(5);
		root.right.left=new BinaryTreeNode(6);
		root.right.left.right=new BinaryTreeNode(7);
		
		Random rand=new Random();
		*/
		
	
		
		BinaryTreeNode root=new BinaryTreeNode(6);
		
		AvlTrees tree=new AvlTrees(root);
		/*
		tree.insert(new BinaryTreeNode(3));
		tree.insert(new BinaryTreeNode(8));
		tree.insert(new BinaryTreeNode(0));
		tree.insert(new BinaryTreeNode(4));
		tree.insert(new BinaryTreeNode(5));
		tree.insert(new BinaryTreeNode(9));
		tree.insert(new BinaryTreeNode(10));
		tree.insert(new BinaryTreeNode(7));
		tree.remove(tree.root, 3);
		*/
		
		tree.add(root, new BinaryTreeNode(3));
		tree.add(root, new BinaryTreeNode(8));
		tree.add(root, new BinaryTreeNode(0));
		tree.add(root, new BinaryTreeNode(4));
		tree.add(root, new BinaryTreeNode(7));
		tree.add(root, new BinaryTreeNode(9));
		tree.add(root, new BinaryTreeNode(5));
		tree.add(root, new BinaryTreeNode(10));
		tree.add(root, new BinaryTreeNode(2));
		//tree.correct(root);
		
		
		
		//SplayTrees tree2=new SplayTrees(tree.root);
		//tree2.insert(11);
		//System.out.println(tree2.contains(1));
		//tree.remove(root,11);
		
		
		System.out.print("PREORDER: ");
		preOrder(tree.root);
		System.out.println("");
		System.out.print("INORDER: ");
		inOrder(tree.root);
		System.out.println("");
		System.out.print("POSTORDER: ");
		postOrder(tree.root);
		System.out.println("");
		System.out.print("BFS: ");
		bfs(tree.root);
		System.out.println("");
		System.out.print("NONRECURSIVE: ");
		dfsNonRecursive(tree.root);
		System.out.println("");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
