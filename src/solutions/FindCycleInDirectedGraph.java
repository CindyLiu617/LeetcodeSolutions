package solutions;

import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.util.Assert;
import solutions.utils.Vertex;

import java.util.*;

/**
 * Created by James on 3/24/16.
 */
public class FindCycleInDirectedGraph {
    static public boolean hasCycle(List<Vertex> graph) {
        if (graph == null)
            return false;
        HashMap<Vertex, Integer> visitStatus = new HashMap<Vertex, Integer>();
        //set white
        for (Vertex v : graph) {
            visitStatus.put(v, 0);
        }
        for (Vertex v : graph) {
            if (visitStatus.get(v) == 0) {
                if (findCycle(v, visitStatus))
                    return true;
            }
        }
        return false;
    }

    static private boolean findCycle(Vertex current, HashMap<Vertex, Integer> visitStatus) {
        //set grey
        visitStatus.put(current, 1);
        if (current.getAdj() != null) {
            for (Vertex i : current.getAdj()) {
                //meet previous vertex
                if (visitStatus.get(i) == 1)
                    return true;
                if (visitStatus.get(i) == 0 && findCycle(i, visitStatus))
                    return true;
            }
        }
        //set black
        visitStatus.put(current, 2);
        return false;
    }


    static public boolean hasCycle2(boolean[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0)
            return false;
        final int numOfVertices = graph.length;
        char[] visitStatus = new char[numOfVertices];
        for (int i = 0; i < numOfVertices; ++i) {
            if (visitStatus[i] == 0) {
                if (findCycle2(graph, i, visitStatus))
                    return true;
            }
        }
        return false;
    }

    static private boolean findCycle2(boolean[][] graph, int vertex, char[] visitStatus) {
        visitStatus[vertex] = 1;
        //find adj
        for (int i = 0; i < graph[vertex].length; ++i) {
            if (graph[vertex][i]) {
                switch (visitStatus[i]) {
                    case 0:
                        if (findCycle2(graph, i, visitStatus))
                            return true;
                        break;
                    case 1:
                        return true;
                    case 2:
                        break;
                    default:
                }
            }
        }
        visitStatus[vertex] = 2;
        return false;
    }

    static public class Test {
        static public void test(boolean[][] graph, boolean ans) {
            Assert.check(ans == FindCycleInDirectedGraph.hasCycle2(graph));
        }

        static public void randomTest() {
            boolean[][] graph1 = {{false, false, true, false}, {true, false, false, false}, {true, true, false, false}, {false, false, false, false}};
            test(graph1, true);

            boolean[][] gragh2 = {{false}};
            test(gragh2, false);

            boolean[][] graph3 = {{true}};
            test(graph3, true);

            boolean[][] graph4 = {{false, false}, {true, false}};
            test(graph4, false);
        }
    }
}
