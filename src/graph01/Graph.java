package graph01;

import edu.princeton.cs.algs4.Bag;

public class Graph{
	private int vertices;
	private int edges;
	private Bag<Integer>[] adj;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		adj = new Bag[vertices];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	
	public void createEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		edges++;
	}
	
	public int getVertices() {
		return vertices;
	}
	
	public int getEdges() {
		return edges;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int v = 0; v < vertices; v++) {
			str.append(v + ":");
			for (int w: adj(v)) {
				str.append(w + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}
	
}