import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
	

	    Queue<BinaryTreeNode>a;
	    public BSTIterator(BinaryTreeNode root) {
	        a=new LinkedList<BinaryTreeNode>();
	        inOrder(root);
	    }
	    public void inOrder(BinaryTreeNode root){
	        if(root==null){
	            return;
	        }
	        inOrder(root.left);
	        a.add(root);
	        inOrder(root.right);
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        return a.poll().value;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !(a.isEmpty());
	    }
	
}
