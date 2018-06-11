package weighteddirected;

import java.util.Stack;

import edu.princeton.cs.algs4.IndexMinPQ;

public class DijkstraShortesPath {
	private WeightedDirectedGraph g;
	private DirectedEdge[] edgeTo;
	private double[] distanceTo;
	private IndexMinPQ<Double> pq;
	
	public DijkstraShortesPath(WeightedDirectedGraph g, int s) {
		this.g= g;
		edgeTo = new DirectedEdge[g.getVertices()];
		distanceTo = new double[g.getVertices()];
		pq = new IndexMinPQ<Double>(g.getVertices());
		for (int i = 0; i < distanceTo.length; i++) {
			distanceTo [i] = Double.POSITIVE_INFINITY;
		}
		distanceTo[s] = 0.0;
		pq.insert(s, 0.0);
		while(! pq.isEmpty()) {
			relax(pq.delMin());
		}
	}
	private void relax(int v) {
		for(DirectedEdge e: g.adj(v)) {
			int w = e.to();
			if(distanceTo[w]>distanceTo[v] + e.weight()) {
				distanceTo[w] = distanceTo[v] + e.weight();
				edgeTo[w] = e;
				if(pq.contains(w)) {
					pq.changeKey(w, distanceTo[w]);
				}else
					pq.insert(w, distanceTo[w]);
			}
		}
	}
	public double distanceTo(int v) {
		return distanceTo[v];
	}
	public Iterable<DirectedEdge> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
	public boolean hasPathTo(int v) {
		return distanceTo[v] < Double.POSITIVE_INFINITY;
	}

}
