package weightedundirected;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimEagerMST {
	private EdgeWeightedGraph g;
	private boolean[] marked;
	private Edge[] edgeTo;
	private double[] distanceTo;
	private IndexMinPQ<Double> pq;
	
	public PrimEagerMST(EdgeWeightedGraph g) {
		this.g = g;
		marked = new boolean[g.getVertices()];
		edgeTo = new Edge[g.getVertices()];
		distanceTo = new double[g.getVertices()];
		pq = new IndexMinPQ<Double>(g.getVertices());
		for (int v = 0; v < g.getVertices(); v++) {
			distanceTo[v] = Double.POSITIVE_INFINITY;
		}
		distanceTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty()) {
			visit(pq.delMin());
		}
	}
	private void visit(int v) {
		marked[v] = true;
		for(Edge e:g.adj(v)) {
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.getWeight()<distanceTo[w]) {
				edgeTo[w] = e;
				distanceTo[w] = e.getWeight();
				if(pq.contains(w)) 
					pq.changeKey(w, distanceTo[w]);
				else
					pq.insert(w, distanceTo[w]);
			}
		}
	}
	public Iterable<Edge> edges(){
		Queue<Edge> mst = new Queue<Edge>();
		for(Edge e:edgeTo) {
			if(e != null)
				mst.enqueue(e);
		}
		return mst;
	}

	public double getWeight() {
		double weight = 0.0;
		for(Edge e:edges()) {
			weight += e.getWeight();
		}
		return weight;
	}
}
