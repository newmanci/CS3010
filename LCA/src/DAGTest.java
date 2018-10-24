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
	
	}

}
