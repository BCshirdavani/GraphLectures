package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
	private ST<String, Integer> st;
	private String[] keys;
	private Graph g;
	
	public SymbolGraph(String fileName, String delim) {
        st = new ST<String, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(fileName);
        // while (in.hasNextLine()) {
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(delim);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        // inverted index to get string keys in an array
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the graph by connecting first vertex on each
        // line to all others
        g = new Graph(st.size());
        in = new In(fileName);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delim);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                g.createEdge(v, w);
            }
        }
	}
	public boolean contains(String s) {
		return st.contains(s);
	}
	public int indexOf(String s) {
		return st.get(s);
	}
	public String nameOf(int v) {
		return keys[v];
	}
	public Graph graph() {
		return g;
	}
	
}
