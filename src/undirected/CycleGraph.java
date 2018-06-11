package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;


public class CycleGraph {
	private Graph g;
	private boolean marked[];
	private boolean hasCycle = false;
	
	public CycleGraph(Graph g) {
		this.g= g;
		marked = new boolean[g.getVertices()];
		for (int v = 0; v < g.getVertices(); v++) {
			if(!marked[v])
				search(g, -1, v);
		}
	}
	public void search(Graph g, int u, int v) {
		marked[v] = true;
		for(int w: g.adj(v)) {
			if(!marked[v]) {
				search(g,v,w);
			}else if(w!=u) {
					hasCycle = true;	
			}
		}
	}
	public boolean hasCycle() {
		return hasCycle;
	}
	
}
