package directed;

public class DirectedDFS {
	private boolean marked[];
	
	public DirectedDFS(DirectedGraph g, int s) {
		marked = new boolean[g.getVertices()];
		dfs(g,s);
	}
	public DirectedDFS(DirectedGraph g, Iterable<Integer> sources) {
		marked = new boolean[g.getVertices()];
		for(int s:sources) {
			if(!marked[s])
				dfs(g, s);
		}
	}
	private void dfs(DirectedGraph g, int v) {
		marked[v] = true;
		for(int w:g.adj(v)) {
			if(!marked[w])
				dfs(g, w);
		}
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
}
