package directed;

import edu.princeton.cs.algs4.In;

public class TopologicalTest {

	public static void main(String[] args) {
//		In in = new In("input.txt");
//		In in = new In("tinyDAG.txt");
		In in = new In("DAG02.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		DirectedGraph g = new DirectedGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			g.createDirectedEdge(v, w);
		}
		Topological topological = new Topological(g);
		if(topological.isDAG())
			System.out.println("\nTopo Order:\n" + topological.order());
		else
			System.out.println("it is not a DAG");
	}

}
