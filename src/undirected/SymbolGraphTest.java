package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolGraphTest {
    public static void main(String[] args) {
        String filename  = "movies.txt";
        String delimiter = "/";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        while (StdIn.hasNextLine()) {
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                int s = sg.indexOf(source);
                for (int v : graph.adj(s)) {
                    StdOut.println("   " + sg.nameOf(v));
                }
            }
            else {
                StdOut.println("input not contain '" + source + "'");
            }
        }
    }
	
}
