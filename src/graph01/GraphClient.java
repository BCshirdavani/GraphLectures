package graph01;

//import org.serce.algorithms.graph.undirected.BreadthFirstSearch;
//import org.serce.algorithms.graph.undirected.DepthFirstSearch;

import edu.princeton.cs.algs4.In;

public class GraphClient {
	
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
		System.out.println(g);
		System.out.println("DFS");
		int start = 0;
		DepthFirstSearch dSearch = new DepthFirstSearch(g, start);
		System.out.print("Visited:");
		for(int v = 0; v < vertices;v++) {
			if(dSearch.marked(v)) {
				System.out.print(v + " ");
			}
		}
		System.out.println("\nv = " + g.getVertices());
		System.out.println("\nstart = " + start);
		for(int v = 0; v < vertices;v++) {
			System.out.print(start + " to " + v + " :");
			for (int x : dSearch.pathTo(v)) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\nBFS");
		BreadthFirstSearch bSearch = new BreadthFirstSearch(g, 0);
		System.out.print("Visited:");
		for(int v=0; v<vertices;v++) {
			if(bSearch.marked(v)) {
				System.out.print(v + " ");
			}
		}
		System.out.println("\nPath to 5");
		for(int v = 0; v < vertices;v++) {
			System.out.print(0 + " to " + v + " :");
			for (int x : bSearch.pathTo(v)) {
				System.out.print(x + " ");
			}
			System.out.print("\n");
		}
		
	}

}
