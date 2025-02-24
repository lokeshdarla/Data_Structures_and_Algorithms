#include <stdio.h>
#define INF 999999

int bfs(int graph[101][101], int source, int sink, int parent[])
{
  int visited[101] = {0};
  int queue[101];
  int front = -1, rear = -1;
  queue[++rear] = source;
  visited[source] = 1;
  parent[source] = -1;

  while (front != rear)
  {
    int u = queue[++front];
    for (int v = 0; v <= 100; v++)
    {
      if (graph[u][v] && !visited[v])
      {
        queue[++rear] = v;
        visited[v] = 1;
        parent[v] = u;
        if (v == sink)
          return 1;
      }
    }
  }

  return 0;
}

int fordFulkerson(int graph[101][101], int source, int sink)
{
  int parent[101];
  int max_flow = 0;

  while (bfs(graph, source, sink, parent))
  {
    int path_flow = INF;
    for (int v = sink; v != source; v = parent[v])
      path_flow = min(path_flow, graph[parent[v]][v]);

    max_flow += path_flow;

    for (int v = sink; v != source; v = parent[v])
    {
      graph[parent[v]][v] -= path_flow;
      graph[v][parent[v]] += path_flow;
    }
  }

  return max_flow;
}

int min(int a, int b)
{
  return (a < b) ? a : b;
}

int main()
{
  int vertices;
  printf("Enter the number of edges in the graph: ");
  scanf("%d", &vertices);
  printf("\nEnter the capacity matrix of the graph: ");
  int graph[101][101];
  for (int i = 0; i < vertices; i++)
  {
    for (int j = 0; j < vertices; j++)
    {
      scanf("%d", &graph[i][j]);
    }
  }
  int source, sink;
  printf("\nEnter the source and sink: ");
  scanf("%d%d", &source, &sink);
  printf("Maximum possible flow is %d\n", fordFulkerson(graph, source, sink));

  return 0;
}
