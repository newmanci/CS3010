import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	
	 @Test
	    public void test1() {
	        TreeNode root = Helper.getRoot();
	        TreeNode two = new TreeNode(2);
	        TreeNode five = new TreeNode(5);
	        Assert.assertEquals(lowestCommonAncestor(root, two, five), 2);
	    }

	    @Test
	    public void test2() {
	        TreeNode root = Helper.getRoot();
	        TreeNode one = new TreeNode(1);
	        TreeNode nine = new TreeNode(9);
	        Assert.assertEquals(lowestCommonAncestor(root, one, nine), 6);
	    }

	    @Test
	    public void test3() {
	        TreeNode root = Helper.getRoot();
	        TreeNode one = new TreeNode(1);
	        TreeNode five = new TreeNode(5);
	        Assert.assertEquals(lowestCommonAncestor(root, one, five), 2);
	    }

	}

}
