package directed;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFSTest {
	
	public static void main(String[] args) {
		In in = new In("tinyDG.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		DirectedGraph dg = new DirectedGraph(vertices);
		for (int i = 0; i < edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			dg.createDirectedEdge(v, w);
			System.out.println("edge: " + v + "-> " + w);
		}
		StdOut.println("Graph");
		System.out.println("Directed Graph:\n" + dg);
		StdOut.print("enter a vertex:");
		int s = StdIn.readInt();
		DirectedDFS dfs = new DirectedDFS(dg, s);
		for (int v = 0; v < vertices; v++) {
			if(dfs.marked(v)) {
				StdOut.print(v + " ");
			}
		}
	}

}
