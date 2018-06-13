package directed;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DirectedCycleTest {
	public static void main(String[] args) {
//		In in = new In("simple.txt");
		In in = new In("tinyDG.txt");
//		In in = new In("straigt.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		DirectedGraph g = new DirectedGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			g.createDirectedEdge(v, w);
			System.out.println("edge: " + v + "-> " + w);
		}
		StdOut.println("Graph");
		StdOut.println(g);

		DirectedCycle dc = new DirectedCycle(g);
		if(dc.hasCycle()) {
			StdOut.print(dc.cycle());
		}
	}

}
