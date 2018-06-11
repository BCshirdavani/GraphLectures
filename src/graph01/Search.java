package graph01;

import java.util.Stack;

public abstract class Search {
	protected Graph g;
	protected boolean[] marked;
	protected int[] edgeTo;
	protected int s;

	public Search(Graph g, int s) {
		this.g = g;
		this.s = s;
		edgeTo = new int[g.getVertices()];
		marked = new boolean[g.getVertices()];
	}
	
	public abstract void search(int s);
	
	public boolean marked(int v) {
		return marked[v];
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x!= s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		
		return path;
	}
}
