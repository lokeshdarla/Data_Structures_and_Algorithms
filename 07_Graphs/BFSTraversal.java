import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge {
  int destination;

  public Edge(int destination) {
    this.destination = destination;
  }
}

public class BFSTraversal {

  public static void bfsTraversal(ArrayList<Edge>[] graph, int v) {

    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.length];

    queue.offer(v);
    visited[v] = true;

    while (!queue.isEmpty()) {

      int n = queue.poll();
      System.out.println(n);

      for (Edge edge : graph[n]) {
        int neighbour = edge.destination;

        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.offer(neighbour);
        }
      }
    }
  }

  public static void main(String[] args) {
    int V = 5;
    ArrayList<Edge>[] graph = new ArrayList[V];

    for (int i = 0; i < V; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(1));
    graph[0].add(new Edge(2));
    graph[1].add(new Edge(3));
    graph[1].add(new Edge(4));
    graph[2].add(new Edge(4));

    System.out.println("BFS traversal starting from node 0:");
    bfsTraversal(graph, 0);
  }
}
