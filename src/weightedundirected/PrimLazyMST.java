package weightedundirected;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimLazyMST {
	private EdgeWeightedGraph g;
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;
	private double weight;
	
	public PrimLazyMST(EdgeWeightedGraph g) {
		this.g = g;
		marked = new boolean[g.getVertices()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>();
		
		visit(0);
		while(!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			System.out.println("marked[v] && marked[w]" + v + " " + w + ": " + (marked[v] && marked[w]));
			if(marked[v] && marked[w]) continue;
			System.out.println("mst.enqueue(" + e + ")");
			mst.enqueue(e);
			weight += e.getWeight();
			if(!marked[v]){
				System.out.println("\t!marked[v] = " + (!marked[v]));
				visit(v);
			}
			if(!marked[w]) {
				System.out.println("\t!marked[w] = " + (!marked[w]));
				visit(w);
			}
		}
	}

	private void visit(int v) {
		System.out.println("\t\tvisit(" + v + ")");
		marked[v] = true;
		for (Edge e:g.adj(v)) {
			int w = e.other(v);
			if(! marked[w]) {
				pq.insert(e);
			}
		}
	}

	public Iterable<Edge> edges(){
		return mst;
	}
	public double getWeight() {
		return weight;
	}

}
