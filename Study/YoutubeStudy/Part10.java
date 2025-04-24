// Part 10. ArrayList

// 코딩 테스트: 대부분의 그래프 문제에서 사용. (특히, 인접 리스트)
// >> Java에서 대부분의 그래프 데이터를 저장하는 자료구조.

/**
 * [Graph Image Link]
 * 
 * 1. Not Directed & Not Weighted Graph. (CASE 1)
 *  https://github.com/Jiseoup/java-self-study/blob/main/Images/NON_DIRECTED_AND_WEIGHTED_GRAPH.png
 * 
 * 2. Directed & Weighted Graph. (CASE 2)
 *  https://github.com/Jiseoup/java-self-study/blob/main/Images/DIRECTED_AND_WEIGHTED_GRAPH.png
 */

package Study.YoutubeStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class Part10 {
    public static void main(String[] args) {
        try {
            AdjacencyMatrixExample.runNonDirectedWeighted();
            AdjacencyMatrixExample.runDirectedWeighted();
            AdjacencyListExample.runNonDirectedWeighted();
            AdjacencyListExample.runDirectedWeighted();
        }
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}


class AdjacencyMatrix {
    private int[][] matrix;

    // Initialize Adjacency Matrix.
    public AdjacencyMatrix(int size) {
        this.matrix = new int[size][size];
    }

    // Add Not Directed & Not Weighted Edge.
    public void addEdge(int startNode, int endNode) {
        matrix[startNode][endNode] = matrix[endNode][startNode] = 1;
    }

    // Add Directed & Not Weighted Edge.
    public void addDirectedEdge(int startNode, int endNode) {
        matrix[startNode][endNode] = 1;
    }

    // Add Not Directed & Weighted Edge.
    public void addWeightedEdge(int startNode, int endNode, int weight) {
        matrix[startNode][endNode] = matrix[endNode][startNode] = weight;
    }

    // Add Directed & Weighted Edge.
    public void addDirectedWeightedEdge(int startNode, int endNode, int weight) {
        matrix[startNode][endNode] = weight;
    }

    // Print Adjacency Matrix.
    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int m : matrix[i]) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Get Node Data.
    public void getNodeData(int node) {
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[node][i];

            if (weight != 0) {
                System.out.printf("End Node: %d, Weight: %d\n", i, weight);
            }
        }
    }
}


// 1. Adjacency Matrix Example.
class AdjacencyMatrixExample {
    private static final int SIZE = 4;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1. Adjacency Matrix Example. (Not Directed & Not Weighted)
    public static void runNonDirectedWeighted() throws Exception {
        System.out.println("[Adjacency Matrix Example: Not Directed & Not Weighted]");

        AdjacencyMatrix matrix = new AdjacencyMatrix(SIZE);

        // Add edges between nodes.
        matrix.addEdge(0, 2);
        matrix.addEdge(1, 0);
        matrix.addEdge(1, 2);
        matrix.addEdge(3, 2);

        matrix.print();

        // Node Selector.
        System.out.printf("Select Node (0~%d): ", SIZE - 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int selectedNode = Integer.parseInt(st.nextToken());

        // Print End Nodes and Weights.
        matrix.getNodeData(selectedNode);

        System.out.println();
    }

    // 2. Adjacency Matrix Example. (Directed & Weighted)
    public static void runDirectedWeighted() throws Exception {
        System.out.println("[Adjacency Matrix Example: Directed & Weighted)");

        AdjacencyMatrix matrix = new AdjacencyMatrix(SIZE);

        // Add edges between nodes.
        matrix.addDirectedWeightedEdge(0, 2, 7);
        matrix.addDirectedWeightedEdge(1, 0, 3);
        matrix.addWeightedEdge(1, 2, 8);
        matrix.addDirectedWeightedEdge(3, 2, 4);

        matrix.print();

        // Node Selector.
        System.out.printf("Select Node (0~%d): ", SIZE - 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int selectedNode = Integer.parseInt(st.nextToken());

        // Print End Nodes and Weights.
        matrix.getNodeData(selectedNode);

        System.out.println();
    }
}


class ListType {
    // Constants for distinguish List Types.
    public static final int NONDIRECTEDWEIGHTED = 0;
    public static final int DIRECTEDWEIGHTED = 1;
}


class Edge {
    int endNode;
    int weight;

    public Edge(int endNode, int weight) {
        this.endNode = endNode;
        this.weight = weight;
    }
}


class AdjacencyList {
    public int listType;
    private ArrayList<Edge>[] list;

    // Initialize Adjacency List.
    @SuppressWarnings("unchecked")
    public AdjacencyList(int size) {
        this.list = new ArrayList[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Edge>();
        }
    }

    // Add Not Directed & Not Weighted Edge.
    public void addEdge(int startNode, int endNode) {
        list[startNode].add(new Edge(endNode, 1));
        list[endNode].add(new Edge(startNode, 1));
    }

    // Add Directed & Not Weighted Edge.
    public void addDirectedEdge(int startNode, int endNode) {
        list[startNode].add(new Edge(endNode, 1));
    }

    // Add Not Directed & Weighted Edge.
    public void addWeightedEdge(int startNode, int endNode, int weight) {
        list[startNode].add(new Edge(endNode, weight));
        list[endNode].add(new Edge(startNode, weight));
    }

    // Add Directed & Weighted Edge.
    public void addDirectedWeightedEdge(int startNode, int endNode, int weight) {
        list[startNode].add(new Edge(endNode, weight));
    }

    // Print Adjacency List.
    public void print() {
        switch (listType) {
            case ListType.NONDIRECTEDWEIGHTED:
                for (int i = 0; i < list.length; i++) {
                    System.out.print("[");

                    ArrayList<Edge> edges = list[i];
                    int listSize = edges.size();

                    for (int j = 0; j < listSize; j++) {
                        System.out.print(edges.get(j).endNode);

                        if (j < listSize - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
                break;

            case ListType.DIRECTEDWEIGHTED:
                for (int i = 0; i < list.length; i++) {
                    boolean isEmpty = true;

                    for (Edge e : list[i]) {
                        isEmpty = false;
                        System.out.printf("[%d, %d] ", e.endNode, e.weight);
                    }

                    if (isEmpty) {
                        System.out.print("[]");
                    }
                    System.out.println();
                }
                break;

            default:
                throw new IllegalArgumentException("Unsupported List Type: " + listType);
        }
        System.out.println();
    }

    // Get Node Data.
    public void getNodeData(int node) {
        for (Edge edge : list[node]) {
            System.out.printf("End Node: %d, Weight: %d\n", edge.endNode, edge.weight);
        }
    }
}


// 2. Adjacency List Example.
class AdjacencyListExample {
    private static final int SIZE = 4;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // CASE 1. Not Directed & Not Weighted
    public static void runNonDirectedWeighted() throws Exception {
        System.out.println("[Adjacency Matrix Example: Not Directed & Not Weighted]");

        AdjacencyList list = new AdjacencyList(SIZE);
        list.listType = ListType.NONDIRECTEDWEIGHTED;

        // Add edges between nodes.
        list.addEdge(0, 1);
        list.addEdge(0, 2);
        list.addEdge(1, 2);
        list.addEdge(2, 3);

        list.print();

        // Node Selector.
        System.out.printf("Select Node (0~%d): ", SIZE - 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int selectedNode = Integer.parseInt(st.nextToken());

        // Print End Nodes and Weights.
        list.getNodeData(selectedNode);

        System.out.println();
    }

    // CASE 2. Directed & Weighted
    public static void runDirectedWeighted() throws Exception {
        System.out.println("[Adjacency List Example: Directed & Weighted]");

        AdjacencyList list = new AdjacencyList(SIZE);
        list.listType = ListType.DIRECTEDWEIGHTED;

        // Add edges between nodes.
        list.addDirectedWeightedEdge(0, 2, 7);
        list.addDirectedWeightedEdge(1, 0, 3);
        list.addWeightedEdge(1, 2, 8);
        list.addDirectedWeightedEdge(3, 2, 4);

        list.print();

        // Node Selector.
        System.out.printf("Select Node (0~%d): ", SIZE - 1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int selectedNode = Integer.parseInt(st.nextToken());

        // Print End Nodes and Weights.
        list.getNodeData(selectedNode);

        System.out.println();
    }
}
