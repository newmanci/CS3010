import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test // test with no nodes
	public void testEmpty() {
		LowestCommonAncestor<Integer> testBST = new LowestCommonAncestor<Integer>();

		assertNull( testBST.search(testBST.root, 7, 1));
	}
}

