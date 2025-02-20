
import java.util.ArrayList;
import java.util.*;

public class sol1 {
    private static int[] longestPath;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        System.out.println("Enter the edges:");
        for (int i = 0; i < edges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.get(source).add(destination);
        }
        System.out.print("Enter the source vertex: ");
        int sourceVertex = sc.nextInt();
        System.out.print("Enter the destination vertex: ");
        int destinationVertex = sc.nextInt();
        sc.close();
        int longestPathLength = findLongestPath(graph, sourceVertex, destinationVertex);
        System.out.println("The longest path length between " + sourceVertex + " and " + destinationVertex + " is: " + longestPathLength);
        System.out.println("The longest path is: " + Arrays.toString(longestPath));
    }

    private static int findLongestPath(List<List<Integer>> graph, int source, int destination) {
        int vertices = graph.size();
        longestPath = new int[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i);
            }
        }

        Arrays.fill(longestPath, Integer.MIN_VALUE);
        longestPath[source] = 0;
        for (int i = 0; i < vertices; i++) {
            int vertex = longestPath[i];
            if (vertex != Integer.MIN_VALUE) {
                List<Integer> neighbors = graph.get(i);
                for (int neighbor : neighbors) {
                    if (longestPath[neighbor] < longestPath[i] + 1) {
                        longestPath[neighbor] = longestPath[i] + 1;
                    }
                }
            }
        }
        return longestPath[destination];
    }

    private static void topologicalSort(List<List<Integer>> graph, int vertex) {
        visited[vertex] = true;
        List<Integer> neighbors = graph.get(vertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                topologicalSort(graph, neighbor);
            }
        }
    }
}