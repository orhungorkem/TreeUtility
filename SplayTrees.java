
public class SplayTrees {
	
	BinaryTreeNode root;

	public SplayTrees(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void add(BinaryTreeNode root,BinaryTreeNode added) {
		if(root.value<added.value) {
			if(root.right!=null) {
				add(root.right,added);
			}
			else {
				root.right=added;
			}
		}
		else if(root.value==added.value) {
			
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
	
	public BinaryTreeNode search(int value) {
		BinaryTreeNode current=root;
		while(current.value!=value) {
			if(current.value>value) {
				if(current.left!=null) {
					current=current.left;
					continue;
				}
				else {
					return current;
				}
			}
			else {
				if(current.right!=null) {
					current=current.right;
					continue;
				}
				else {
					return current;
				}
			}
		}
		return current;
	}
	
	/**
	 * Insert normally
	 * Splay inserted node
	 * If duplicate, splay duplicate
	 */
	public void insert(int value) {
		BinaryTreeNode added=new BinaryTreeNode(value);
		add(root,added);
		while(!root.equals(added)) {
			splay(root,added);
		}
	}
	
	
	/**
	 * Search for node
	 * If found, splay it; otherwise, splay the last node accessed
	 */
	public boolean contains(int value) {
		BinaryTreeNode splayed=search(value);
		while(!root.equals(splayed)) {
			splay(root,splayed);
		}
		return search(value).value==value;
	}
	
	
	/**
	 * Splay the element to be removed(If not in the tree, last visited should be splayed.)
	 * Disconnect left right subtrees from root.
	 * Splay max item in left tree, item wont have right child, connect right to right tree.
	 * Or splay min item in right tree, item wont have left child, connect left to left tree.
	 */
	public void remove(int value) { //FOR INTEGERS
		BinaryTreeNode splayed=search(value);
		while(!root.equals(splayed)) {
			splay(root,splayed);
		}
		if(splayed.left!=null&&splayed.right!=null) {
			BinaryTreeNode leftTree=splayed.left;
			BinaryTreeNode rightTree=splayed.right;
		
			splayed.left=null;
			splayed.right=null;
			splayed=search(splayed.value-1);
			root=leftTree;
			while(!root.equals(splayed)) {
				splay(root,splayed);
			}
			root.right=rightTree;
			return;
		}
		else if(splayed.left!=null) {
			BinaryTreeNode leftTree=splayed.left;
			splayed.left=null;
			root=leftTree;
			splayed=search(splayed.value-1);
			while(!root.equals(splayed)) {
				splay(root,splayed);
			}
			return;
		}
		else if(splayed.right!=null) {
			BinaryTreeNode rightTree=splayed.right;
			splayed.right=null;
			root=rightTree;
			splayed=search(splayed.value+1);
			while(!root.equals(splayed)) {
				splay(root,splayed);
			}
			return;
		}
		else {
			root=null;
			return;
		}
		
	}
	
	
	/**
	 * If wanted has no grandparent, rotate wanted over its parent.
	 * Else: If wanted is right child of right child or left of left, rotate parent over grandparent,
	 * 		then rotate wanted over its parent.
	 * 		
	 * 		If wanted and parent are opposite children, rotate wanted over its parent,
	 * 		then rotate wanted over its new parent(grandparent).
	 */
	public BinaryTreeNode splay(BinaryTreeNode current, BinaryTreeNode wanted) {
		
		if(current.equals(wanted)) {
			return current;
		}
		if(current.value>wanted.value) {
			if(wanted.equals(current.left)) {
				this.root=AvlTrees.rightRotation(current);
				return this.root;
			}
			if(wanted.value<current.left.value) {
				if(wanted.equals(current.left.left)) {
					BinaryTreeNode tempRoot=AvlTrees.rightRotation(current);
					if(current.equals(this.root)) {
						this.root=AvlTrees.rightRotation(tempRoot);
						return this.root;
					}
					return AvlTrees.rightRotation(tempRoot);
				}
				else {
					current.left=splay(current.left,wanted);
					return current;
					
				}
			}
			if(wanted.value>current.left.value) {
				if(wanted.equals(current.left.right)) {
					current.left=AvlTrees.leftRotation(current.left); 
					if(current.equals(this.root)) {
						this.root=AvlTrees.rightRotation(current);
						return this.root;
					}
					return AvlTrees.rightRotation(current);
				}
				else {
					current.left=splay(current.left,wanted);
					return current;
				}
			}
		}
		if(current.value<wanted.value) {
			if(wanted.equals(current.right)) {
				this.root=AvlTrees.leftRotation(current);
				return this.root;
			}
			if(wanted.value>current.right.value) {
				if(wanted.equals(current.right.right)) {
					BinaryTreeNode tempRoot=AvlTrees.leftRotation(current);
					if(current.equals(this.root)) {
						this.root=AvlTrees.leftRotation(tempRoot);
						return this.root;
					}
					return AvlTrees.leftRotation(tempRoot);
				}
				else {
					current.right=splay(current.right,wanted);
					return current;
				}
			}
			if(wanted.value<current.right.value) {
				if(wanted.equals(current.right.left)) {
					current.right=AvlTrees.rightRotation(current.right); //ekleme
					if(current.equals(this.root)) {
						this.root=AvlTrees.leftRotation(current);
						return this.root;
					}
					return AvlTrees.leftRotation(current);
				}
				else {
					current.right=splay(current.right,wanted);
					return current;
				}
			}
		}
		return current;
		
		
		
		
	}
	

	
	
	
	
}








