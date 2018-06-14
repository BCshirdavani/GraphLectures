package directed;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private DirectedGraph g;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	
	public DepthFirstOrder(DirectedGraph g) {
		this.g = g;
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[g.getVertices()];
		for (int v = 0; v < g.getVertices(); v++) {
			if(!marked[v])
				dfs(v);
		}
		
	}
	private void dfs(int v) {
		pre.enqueue(v);
//		System.out.println("- order\tpre.enqueue(" + v + ")");
		marked[v] = true;
		System.out.println("* order\t\tmarked[" + v + "] = true");
		for(int w:g.adj(v)) {
			if(!marked[w]) {
				dfs(w);
			}
		}
		System.out.println("+ order\tpost.enqueue(" + v + ")");
		post.enqueue(v);
		System.out.println("- order\treversePost.push(" + v + ")");
		reversePost.push(v);
	}


	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}

}
