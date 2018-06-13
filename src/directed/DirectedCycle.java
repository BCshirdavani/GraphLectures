package directed;

import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	private DirectedGraph g;
	
	public DirectedCycle(DirectedGraph g) {
		this.g= g;
		marked = new boolean[g.getVertices()];
		edgeTo = new int[g.getVertices()];
		onStack = new boolean[g.getVertices()];
		for (int v = 0; v < g.getVertices(); v++) {
			if(!marked[v]) {
				dfs(v);
			}
		}
	}
	private void dfs(int v) {
		marked[v] = true;
		onStack[v] = true;
		System.out.println("\tmarked["+v+"] = true,\n\tonStack["+v+"] = true");
		for(int w:g.adj(v)) {
			System.out.println("\tcycle == null: " + (cycle == null));
			if(hasCycle()) return;
			if(!marked[w]) {
				System.out.println("\t" + v + " -> " + w);
				edgeTo[w] = v;
				System.out.println("dfs: " + w);
				dfs(w);
			}else if (onStack[w]) {
				System.out.println("********* ON STACK FOUND: " + w + " **************");
				cycle = new Stack<Integer>();
				for(int x=v;x!=w;x=edgeTo[x]) {
					cycle.push(x);
					System.out.println("\t*\tpush: " + x);
				}
				cycle.push(w);
				System.out.println("\t+\tpush: " + w);
				cycle.push(v);
				System.out.println("\t-\tpush: " + v);
			}
		}
		System.out.println("\tonStack["+v+"] = false");
		onStack[v] = false;
	}
	public boolean hasCycle() {

		return cycle!=null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}

}
