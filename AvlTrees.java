
public class AvlTrees {
	
	BinaryTreeNode root;

	public AvlTrees(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * Balanced BST's have logn complexity.
	 * So keeping trees balanced is desired.
	 * AVL trees are BST's that uses modified add, remove operations and keep themselves balanced.
	 */
	
	/**
	 * Each node n has a balance factor.
	 * BF=Height of n.right-n.left   (Height of empty tree=-1)
	 * For AVL trees every node has BF=1,0,-1
	 */
	
	/**
	 * To keep a tree balanced in insertion, removal operations, nodes are organized.
	 * Adding left to a left child---Right rotation
	 * Adding right to a right child---Left rotation
	 * Adding right to a left child---Left rot of left child + Right rot of parent
	 * Adding left to a right child---Right rot of right child + Left rot of parent
	 */
	
	public static BinaryTreeNode rightRotation(BinaryTreeNode root) {
		if(root.left==null) {
			return root;
		}
		BinaryTreeNode newRoot=root.left;
		if(newRoot.right!=null) {
			root.left=newRoot.right;
		}
		else {
			root.left=null;
		}
		newRoot.right=root;
		return newRoot;
	}
	
	public static BinaryTreeNode leftRotation(BinaryTreeNode root) {
		if(root.right==null) {
			return root;
		}
		BinaryTreeNode newRoot=root.right;
		if(newRoot.left!=null) {
			root.right=newRoot.left;
		}
		else {
			root.right=null;
		}
		newRoot.left=root;
		return newRoot;
	}
	
	public void add(BinaryTreeNode root,BinaryTreeNode added) { //WITHOUT ROTATION
		if(root.value<added.value) {
			if(root.right!=null) {
				add(root.right,added);
			}
			else {
				root.right=added;
			}
		}
		else if(root.value==added.value) {
			System.out.println("INVALID INPUT");
		}
		else {
			if(root.left!=null) {
				add(root.left,added);
			}
			else {
				root.left=added;
			}
		}
	}
	
	public BinaryTreeNode remove(BinaryTreeNode root,int data) {
		
		if(root==null) {
			return null;
		}
		BinaryTreeNode cur=root;
		if(cur.value==data) { // ROOT REMOVE EDİLECEKSE
			if(cur.right!=null) {
				if(cur.left==null) {
					root=cur.right;
					cur.right=null;
					return root;
				}
				root=cur.right;
				if(cur.right.left!=null) {
					BinaryTreeNode afterAdd=cur.right.left;
					root.left=cur.left;
					add(root,afterAdd);
					return root;
				}
				else {
					root.left=cur.left;
					return root;
				}
			}
			else if(cur.left!=null){
				root=cur.left;
				cur.left=null;
				return root;
			}
			else {
				root=null;
				return null;
			}
		}
		cur.left=remove(cur.left,data);
		cur.right=remove(cur.right,data);
		correct(cur);
		return cur;
		
		
		
		
		
	}
	
	
	
	/**
	 * IMPLEMENT ADDITION WITH REBALANCING
	 * add(root, added)
	 * Update heights/balance factors
	 * Postorder traverse check bf
	 * Implement corrections
	 * Return final root
	 */
	
	public void insert(BinaryTreeNode added) {
		add(root,added);
		BinaryTreeNode.getBalanceFactor(root);
		correct(root);
	}
	
	public BinaryTreeNode correct(BinaryTreeNode root) {
		if(root.left!=null) {
			root.left=correct(root.left);
		}
		if(root.right!=null) {
			root.right=correct(root.right);
		}
		BinaryTreeNode.getBalanceFactor(this.root);
		
		BinaryTreeNode current=root;
		if(current.balanceFactor>=2) {
			if(current.left.balanceFactor>=0) {
				if(current.equals(this.root)) {
					this.root=rightRotation(current);
					return this.root;
				}
				return rightRotation(current);
			}
			else {
				current.left=leftRotation(current.left);
				if(current.equals(this.root)) {
					this.root=rightRotation(current);
					return this.root;
				}
				return rightRotation(current);
			}
		}
		else if(current.balanceFactor<=-2) {
			if(current.right.balanceFactor<=0) {
				if(current.equals(this.root)) {
					this.root=leftRotation(current);
					return this.root;
				}
				return leftRotation(current);
			}
			else {
				current.right=rightRotation(current.right);
				if(current.equals(this.root)) {
					this.root=leftRotation(current);
					return this.root;
				}
				return leftRotation(current);
			}
			
		}
		return current;
	}
	
	
	
	





















}





