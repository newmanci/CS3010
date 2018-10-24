import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
public class DAGTest {


	//test cases based on Directed Acyclic Graph similar to Sedgwicks AdjMatrix 

	@Test
	public void testE()
	{
		DAG test1 = new DAG(13);
		assertEquals("testing with no edges",0,test1.E());
		test1.addEdge(1, 2);
		assertEquals("testing with no edges",1,test1.E());
	}

	@Test
	public void testV()
	{
		DAG test1 = new DAG(20);
		assertEquals("testing V() function", 20, test1.V());

	}

	@Test(expected = IllegalArgumentException.class) 
	public void testExceptionThrowers() 
	{
		DAG test = new DAG(6);
		test.adj(-1);
		test.adj(88);
		test.LCA(1, -1);//not possible to have it 
		test.LCA(1, 88);//vertex is out of bounds
		DAG test2 = new DAG(-4); //Shouldn't have negative vertices
	}

	@Test
	public void testAcyclic()
	{
		DAG test1 = new DAG(13);
		test1.addEdge(1, 2);
		test1.addEdge(2, 3);
		test1.addEdge(3, 4);
		test1.isAcyclic();
		assertTrue(test1.acyclic());
		test1.addEdge(4,1);
		test1.isAcyclic();
		assertFalse(test1.acyclic());
	}

	@Test
	public void testLCA()
	{
		DAG test1 = new DAG(15);
		assertEquals("both vertices exist but are not connected", -1,test1.LCA(1, 2));
		test1.addEdge(1, 2);
		test1.addEdge(2, 3);
		test1.addEdge(3, 4);
		test1.addEdge(3, 5);
		assertEquals("We know its 3",3,test1.LCA(4,5));
		assertEquals("We know its 3",3,test1.LCA(5,4));
		test1.addEdge(5, 6);
		test1.addEdge(4, 7);
		test1.addEdge(7,8);
		test1.addEdge(6, 9);
		test1.addEdge(9,10);
		test1.addEdge(8, 10);
		assertEquals("LCA should be at the branch point 3",3, test1.LCA(9,7));
		assertEquals("LCA of 2 of the same line", 7,test1.LCA(7,8));
		assertEquals("LCA of 2 of the same line", 4,test1.LCA(7,4));
		assertEquals("LCA of 2 of the same line", 4,test1.LCA(4,7));
		assertEquals("when one is in the DAG, yet not connected", -1,test1.LCA(13, 4));
		test1.addEdge(9, 1);
		assertEquals("LCA is cyclical",-1,test1.LCA(3, 1));

	}


	@Test 
	public void testReverse()
	{
		DAG test1 = new DAG(10);
		test1.addEdge(1, 2);
		test1.addEdge(0, 1);
		DAG testReverse = test1.reverse();
		assertSame("Edges need to be the same", testReverse.E(),test1.E());
		assertSame("Should not lose vertices", testReverse.V(),test1.V());
		DAG test2 = new DAG(25);
		DAG rev2 = test2.reverse();
		assertSame("Edges need to be the same", rev2.E(),test2.E());
		assertSame("Should not lose vertices", rev2.V(),test2.V());
	}


}



