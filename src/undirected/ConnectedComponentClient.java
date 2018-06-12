package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class ConnectedComponentClient {

	public static void main(String[] args) {
		In in = new In("input3.txt");
		int vertices = in.readInt();
		int edges = in.readInt();
		
		Graph g = new Graph(vertices);
		for(int i=0; i<edges; i++) {
			int v = in.readInt();
			int w = in.readInt();
			g.createEdge(v, w);
		}

		ConnectedComponentDFS cc = new ConnectedComponentDFS(g);
		int n = cc.getCount(); 		// group count
		System.out.println("Printing " + n + " components");
		Queue<Integer>[] components = new Queue[n];
		for (int i = 0; i < n; i++) {
			components[i] = new Queue<Integer>();
		}

		for (int v = 0; v < g.getVertices(); v++) {
			components[cc.id(v)].enqueue(v);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(i + ": " );
			for (int c: components[i]) {
				System.out.print(c + " ");
			}
			System.out.println();
		}

		
	}
}
