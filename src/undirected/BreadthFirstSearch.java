package undirected;

//import org.serce.algorithms.graph.Graph;
//import org.serce.algorithms.graph.Search;
import graph01.Graph;
import graph01.Search;


import edu.princeton.cs.algs4.Queue;

public class BreadthFirstSearch extends Search{
	
	public BreadthFirstSearch(Graph g, int s) {
		super(g, s);
		search(s);
	}

	public void search(int s) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		marked[s] = true;
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for(int w: g.adj(v)) {
				if(! marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					q.enqueue(w);
				}
			}
		}
	}

}
