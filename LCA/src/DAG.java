import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DAG {
private int[] indegree;        // indegree[v] = indegree of vertex v
private final int V;           // number of vertices in this digraph
private int E;                 // number of edges in this digraph
private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v

public DagLCA(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
			
		
		}
}
