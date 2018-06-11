package directed;

import edu.princeton.cs.algs4.Bag;

public class DirectedGraph {
	
	private int vertices;
	private int edges;
	private Bag<Integer>[] adj;
	
	public DirectedGraph(int vertices) {
		this.vertices = vertices;
		adj = new Bag[vertices];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	public void createDirectedEdge(int v, int w) {
		adj[v].add(w);
		edges++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public int getVertices() {
		return vertices;
	}
	
	public int getEdges() {
		return edges;
	}
	public DirectedGraph reverse() {
		DirectedGraph rg = new DirectedGraph(vertices);
		for(int v=0;v<vertices;v++) {
			for(int w:adj[v]) {
				rg.createDirectedEdge(w, v);
			}
		}
		return rg;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int v = 0; v < vertices; v++) {
			str.append(v + ":");
			for(int w:adj[v]) {
				str.append(w + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}
}
