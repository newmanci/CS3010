import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
	private int[] indegree;        // indegree[v] = indegree of vertex v
	private final int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v


	public boolean isDAG;
	public boolean[] marked; //boolean array for visited vertices
	public boolean[] stack; 

	// For DFS 
	public int[]pre;   
	public int[]post  ;
	public ArrayList<Integer> postorder;
	public ArrayList<Integer> preorder ;
	public int preCounter;
	public int postCounter;

	public DAG(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();


		}


		isDAG = true;
		marked = new boolean[V];
		stack = new boolean[V];
		//for DFS
		pre    = new int[V()];
		post   = new int[V()];
		postorder = new ArrayList<Integer>();
		preorder  = new ArrayList<Integer>();
		preCounter=0;
		postCounter=0;
	}

	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int V() {
		return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int E() {
		return E;
	}

	// throw an IllegalArgumentException unless {@code 0 <= v < V}
	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));

	}

	/**
	 * Adds the directed edge v-w to this digraph.
	 *
	 * @param  v the tail vertex
	 * @param  w the head vertex
	 * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
	 */
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}

	/**
	 * Returns the vertices adjacent from vertex {@code v} in this digraph.
	 *
	 * @param  v the vertex
	 * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
	 * @throws IllegalArgumentException unless {@code 0 <= v < V}
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}


	public boolean acyclic()
	{
		return isDAG;	
	}
	//Sedgewick
	public void isAcyclic()
	{
		for(int i=0; i<V()&&isDAG;i++)
		{
			stack = new boolean[V];
			marked= new boolean[V];
			acyclic(i);
		}
	}
	private void acyclic(int v)
	{
		stack[v] =true; 
		marked[v] = true;

		for (int w : adj(v)) {
			if(!marked[w]) {
				acyclic(w);
			} else if (stack[w]) {
				isDAG = false;
				return;
			}
		}
		stack[v] = false;
	}

	public int LCA(int v, int w)
	{
		boolean haveLCA =false;
		//Will be acyclic if reversed so no need to reverse yet
		isAcyclic();
		if(!isDAG){
			return -1;
		}
		validateVertex(v);//exception thrown if invalid
		validateVertex(w);//check if they exist
		if(E==0)// no edges
		{
			return -1;
		}
		//is valid to search now reverse

		DAG  reversed = this.reverse();
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		//Testing DFS first to see if it works       
		ArrayList<Integer> childVSearch =reversed.bfs(v);

		ArrayList<Integer> childWSearch= reversed.bfs(w);
		for(int i = 0; i<childVSearch.size(); i++)
		{
			for(int t = 0; t<childWSearch.size(); t++)
			{		
				if(childVSearch.get(i)==childWSearch.get(t))
				{ // first occurrence of a match is where the lowest common 
					commonAncestors.add(childVSearch.get(i));	
					haveLCA = true;
				}
			}


		}
		if(haveLCA)
			return commonAncestors.get(0);
		else

			return -1;
	}
	//reverse the DAG so we can navigate to parent nodes. th the add edge if thats even allowed

	public DAG reverse() {
		DAG childToParent = new DAG(V);
		for (int v = 0; v < V; v++) 
		{

			for (int w : adj(v)) 
			{
				childToParent.addEdge(w, v);
			}
		}
		return childToParent;
	}
}

