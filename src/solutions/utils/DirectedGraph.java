package solutions.utils;


import java.util.ArrayList;

/**
 * Created by James on 3/24/16.
 */
public class DirectedGraph {
    public Vertex[] vertexList;

    public DirectedGraph(int n) {
        vertexList = new Vertex[n];
    }

    public void addEdge(int start, int end) {
        vertexList[start].addAdj(vertexList[end]);
    }

    public int getVertexNumber() {
        return vertexList.length;
    }

    public void printVertex(Vertex vertex) {
        ArrayList<Vertex> next = vertex.getAdj();
        if (next == null) {
            System.out.println(vertex.toString() + " has not next");
        } else {
            System.out.print(vertex.toString() + "has next:");
            for (Vertex aNext : next) {
                System.out.print("vertex" + aNext.getLabel() + ", ");
            }
            System.out.println();
        }
    }
}
