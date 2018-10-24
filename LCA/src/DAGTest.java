import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
public class DAGTest {

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
	}


