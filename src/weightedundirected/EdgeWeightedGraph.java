package weightedundirected;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraph {
	private final int vertices;
	private int edges;
	private Bag<Edge>[] adj;
	
	public EdgeWeightedGraph(int vertices) {
		this.vertices = vertices;
		adj = new Bag[vertices];
		for (int v = 0; v < vertices; v++) {
			adj[v] = new Bag<Edge>();
		}
	}
	public void createEdge(Edge edge) {
		int v = edge.either();
		int w = edge.other(v);
		adj[v].add(edge);
		adj[w].add(edge);
		edges++;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public Iterable<Edge> edges(){
		Bag<Edge> edges = new Bag<Edge>();
		for (int v = 0; v < vertices; v++) {
			for(Edge edge:adj[v]) {
				if(edge.other(v)>v)
					edges.add(edge);
			}
			
		}
		return edges;
	}
	public int getEdges() {
		return edges;
	}
	public int getVertices() {
		return vertices;
	}

}
