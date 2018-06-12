package undirected;

//import org.serce.algorithms.graph.Graph;
import graph01.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SymbolGraphTest {
    public static void main(String[] args) {
//        String filename  = "movies.txt";
        String filename  = "movies2.txt";
        StdOut.println("filename: " + filename);
        String delimiter = "/";
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        StdOut.println("about to loop...");
        while (StdIn.hasNextLine()) {
            StdOut.println("has next line...");
            String source = StdIn.readLine();
            if (sg.contains(source)) {
                StdOut.println("sg contains source...");
                int s = sg.indexOf(source);
                for (int v : graph.adj(s)) {
                    StdOut.println("   " + sg.nameOf(v));
                }
            }
            else {
                StdOut.println("input not contain '" + source + "'");
            }
        }
        StdOut.println("loop over...");
    }
	
}
