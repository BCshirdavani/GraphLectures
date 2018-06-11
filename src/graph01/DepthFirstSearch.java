package graph01;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch extends Search {

	
	public DepthFirstSearch(Graph g, int s) {
		super(g, s);
		search(s);
	}

	public void search(int v) {
		marked[v] = true;
		for(int w:g.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				search(w);
			}
		}
	}


}
