package undirected;

import java.util.Stack;

//import org.serce.algorithms.graph.Graph;
//import org.serce.algorithms.graph.Search;
import graph01.Graph;
import graph01.Search;

public class DepthFirstSearch extends Search {

	private int count;
	
	public DepthFirstSearch(Graph g, int s) {
		super(g, s);
		search(s);
	}
	public void search(int v) {
		marked[v] = true;
		for(int w: g.adj(v)) {
			if(! marked[w]) {
				edgeTo[w] = v;
				search(w);
			}
		}
	}

	public int getCount() {
		return count;
	}


}
