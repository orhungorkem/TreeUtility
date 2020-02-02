
public class BTrees {

	/**
	 * Data stored only in the leaves.
	 * Internal nodes guide search.
	 * All leaves are in the same level.
	 * Interior nodes store one key, 2 pointers, leaves store multiple data
	 */
	
	/**
	 * MWay trees are not binary.
	 * Interior nodes own M pointers and M-1 data.
	 * Height decresases this way.
	 * These trees limit the number of accesses necessary to disc which is a really slow process.
	 */
	
	/**
	 * For an MWay tree to be a B tree, 
	 * 		Root must have 2-M subtrees
	 * 		Interior nodes must have M/2-M subtrees
	 * 		Leaves must be at the same level
	 * 		Leaves must store between L/2-L data elements(L should be determined)
	 */
	
	/**
	 * We want just one disc access per leaf.
	 * So pick L=Disc block/Data record for leaves
	 * For interior nodes, key*(M-1) + pointer*M<=Disc block
	 */
	
	/**
	 * Insertion
	 * 		Find appropriate leaf, if it has room(has less than L elements) put it there.
	 * 		If not, split it into two leaves, insert x, update keys in parent.
	 * 		If keys in parent are also full, split the keys.
	 */
	
	/**
	 * 	Deletion
	 * 		If leaf has more than L/2 elements, just remove. If necessary change the key of parent.
	 * 		If leaf is too empty, borrow element from neighbor,
	 * 			if neighbor also empty, combine them into one leaf.
	 * 			Parent should be updated.
	 */
	
}
