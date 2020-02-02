
public class BinaryTreeNode {
	
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
	int balanceFactor;
	int height;
	
	
	public BinaryTreeNode(int value) {
		this.value = value;
		this.height=1;
		
	}
	
	public static int getHeight(BinaryTreeNode root) {
			
			if(root==null) {
				return -1;
			}
			
			int left=getHeight(root.left);
			int right=getHeight(root.right);
			root.height=Math.max(left, right)+1;
			return root.height;
	}
	
	
	public static int getBalanceFactor(BinaryTreeNode root) {
		
		if(root==null) {
			return 0;
		}
		
		int left=getBalanceFactor(root.left);
		int right=getBalanceFactor(root.right);
		root.height=Math.max(left, right)+1;
		root.balanceFactor=left-right;
		return root.height;
		
		
		
		
	}
	public boolean equals(Object other) {
		if(other instanceof BinaryTreeNode) {
			BinaryTreeNode other2=(BinaryTreeNode)other;
			return other2.value==this.value;
		}
		return false;
	}
	
	
	
}








