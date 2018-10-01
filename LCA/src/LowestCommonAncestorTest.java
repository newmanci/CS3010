import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test // test with no nodes
	public void testEmpty() {
		LowestCommonAncestor<Integer> testBST = new LowestCommonAncestor<Integer>();

		assertNull( testBST.search(testBST.root, 7, 1));
	}
	@Test // test with only one node in
	public void testSingle()
	{
		LowestCommonAncestor<Integer> testBST = new LowestCommonAncestor<Integer>();
		testBST.put(7);
		assertNull(testBST.search(testBST.root,1,3));

	}
}

