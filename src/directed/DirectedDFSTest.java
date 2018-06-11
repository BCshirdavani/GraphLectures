package directed;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFSTest {
	
	public static void main(String[] args) {
		In in = new In("tinyDG.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		DirectedGraph g = new DirectedGraph(vertices);
		for (int i = 0; i < vertices; i++) {
			int v = in.readInt();
			int w = in.readInt();
			g.createDirectedEdge(v, w);
		}
		StdOut.println("Graph");
		StdOut.println(g);
		StdOut.print("Vertex:");
		int s = StdIn.readInt();
		DirectedDFS dfs = new DirectedDFS(g, s);
		for (int v = 0; v < vertices; v++) {
			if(dfs.marked(v)) {
				StdOut.print(v + " ");
			}
		}
	}

}
