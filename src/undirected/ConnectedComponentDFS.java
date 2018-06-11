package undirected;

import java.util.Stack;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;

import edu.princeton.cs.algs4.Queue;

public class ConnectedComponentDFS  {

	private int[] id;
	private boolean[] marked;
	private int count;
	private Graph g;
	
	public ConnectedComponentDFS(Graph g) {
		this.g = g;
		id = new int[g.getVertices()];
		marked = new boolean[g.getVertices()];
		for (int v = 0; v < g.getVertices(); v++) {
			if(!marked[v]) {
				search(v);
				count++;
			}
		}
	}
	public void search(int v) {
		marked[v] = true;
		id[v] = count;
		for(int w: g.adj(v)) {
			if(! marked[w]) {
				search(w);
			}
		}
	}
	public boolean isConnected(int v, int w) {
		return id[v] == id[w];
	}
	public int id(int v) {
		return id[v];
	}
	public int getCount() {
		return count;
	}


}
