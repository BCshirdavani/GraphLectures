package directed;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	private DirectedGraph g;
	
	public DirectedCycle(DirectedGraph g) {
		this.g= g;
		marked = new boolean[g.getVertices()];
		edgeTo = new int[g.getVertices()];
		onStack = new boolean[g.getVertices()];
		for (int v = 0; v < g.getVertices(); v++) {
			if(!marked[v]) {
				dfs(v);
			}
		}
	}
	private void dfs(int v) {
		marked[v] = true;
		onStack[v] = true;
		for(int w:g.adj(v)) {
			if(hasCycle()) return;
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(w);
			}else if (onStack[w]) {
				cycle = new Stack<Integer>();
				for(int x=v;x!=w;x=edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}
	public boolean hasCycle() {
		return cycle!=null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}

}
