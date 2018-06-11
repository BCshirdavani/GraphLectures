package directed;

public class Topological {
	private DirectedGraph dg;
	private Iterable<Integer> order;
	public Topological(DirectedGraph dg) {
		this.dg = dg;
		DirectedCycle dc = new DirectedCycle(dg);
		if(!dc.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(dg);
			order = dfs.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG() {
		return order!=null;
	}

}
