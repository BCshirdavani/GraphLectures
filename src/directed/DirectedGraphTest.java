package directed;

import edu.princeton.cs.algs4.In;

public class DirectedGraphTest {
	
	public static void main(String[] args) {
		In in = new In("tinyDG.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		DirectedGraph dg = new DirectedGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			dg.createDirectedEdge(v, w);
		}
		System.out.println(dg);
		DirectedGraph rg = dg.reverse();
		System.out.println(rg);
	}

}
