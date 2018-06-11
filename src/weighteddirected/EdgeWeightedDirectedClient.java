package weighteddirected;

import edu.princeton.cs.algs4.In;

public class EdgeWeightedDirectedClient {
	
	public static void main(String[] args) {
		In in = new In("weigteddirected.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		WeightedDirectedGraph g = 
				new WeightedDirectedGraph(vertices);
		for (int e = 0; e < edges; e++) {
			int v = in.readInt();
			int w = in.readInt();
			double weight = in.readDouble();
			DirectedEdge edge = new DirectedEdge(v, w, weight);
			g.addEdge(edge);
		}
		DijkstraShortesPath sp = new DijkstraShortesPath(g, 0);
		for(DirectedEdge e:sp.pathTo(5)) {
			System.out.println(e);
		}
		System.out.println(sp.distanceTo(5));
	}

}
