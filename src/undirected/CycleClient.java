package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;

import edu.princeton.cs.algs4.In;

public class CycleClient {
	
	public static void main(String[] args) {
		In in = new In("input2.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		
		Graph g = new Graph(vertices);
		for(int i=0; i<edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			g.createEdge(v, w);
		}
		CycleGraph cg = new CycleGraph(g);
		System.out.println("Has cycle: " + cg.hasCycle());
		
	}

}
