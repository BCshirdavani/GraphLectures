package weightedundirected;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
	private EdgeWeightedGraph g;
	private UF uf;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	private double weight;
	
	public KruskalMST(EdgeWeightedGraph g) {
		this.g= g;
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		for (int v = 0; v < g.getVertices(); v++) {
			for(Edge e:g.adj(v)) {
				if(e.other(v)>v)
					pq.insert(e);
			}
		}
		uf = new UF(g.getVertices());
		
		while(!pq.isEmpty() && mst.size()<g.getVertices()-1) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			mst.enqueue(e);
			weight += e.getWeight();
		}
		
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double getWeight() {
		return weight;
	}
}
