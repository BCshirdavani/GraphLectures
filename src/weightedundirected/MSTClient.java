package weightedundirected;

import edu.princeton.cs.algs4.In;

public class MSTClient {
	
	public static void main(String[] args) {
		In in = new In("mst.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		EdgeWeightedGraph g = new EdgeWeightedGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			Edge edge = new Edge(v, w, weight);
			g.createEdge(edge);
		}
		PrimEagerMST mstFinder = new PrimEagerMST(g);
//		PrimLazyMST mstFinder = new PrimLazyMST(g);
//		KruskalMST mstFinder = new KruskalMST(g);
		for(Edge e:mstFinder.edges()) {
			System.out.println(e);
		}
		System.out.println(mstFinder.getWeight());

	}

}
