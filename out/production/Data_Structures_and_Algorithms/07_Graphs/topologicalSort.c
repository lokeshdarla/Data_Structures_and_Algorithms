#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
  int dest;
  struct Node *next;
} node;

typedef struct adjList
{
  node *head;
} adjList;

typedef struct Graph
{
  int v;
  adjList *array;
} Graph;

node *createNode(int dest)
{
  node *newnode = (node *)malloc(sizeof(node));
  newnode->dest = dest;
  newnode->next = NULL;
  return newnode;
}

Graph *createGraph(int V)
{
  Graph *graph = (Graph *)malloc(sizeof(Graph));
  graph->v = V;
  graph->array = (adjList *)malloc(V * sizeof(adjList));
  for (int i = 0; i < V; i++)
  {
    graph->array[i].head = NULL;
  }
  return graph;
}

void addEdge(Graph *graph, int src, int dest)
{
  node *newnode = createNode(dest);
  newnode->next = graph->array[src].head;
  graph->array[src].head = newnode;

  // newnode = createNode(src);
  // newnode->next = graph->array[dest].head;
  // graph->array[dest].head = newnode;
}

void printGraph(Graph *graph)
{
  int n = graph->v;
  for (int i = 0; i < n; i++)
  {
    node *temp = graph->array[i].head;
    printf("Adjacency List from vertex %d: ", i);
    while (temp != NULL)
    {
      printf("%d ", temp->dest);
      temp = temp->next;
    }
    printf("\n");
  }
}

void BFS(Graph *graph, int *visited, int start)
{
  int *queue = (int *)calloc(graph->v + 1, sizeof(int));
  int front = 0, rear = 0;
  queue[rear++] = start;
  while (front < rear)
  {
    int curr = queue[front++];
    visited[curr] = 1;
    printf("%d ", curr);
    node *temp = graph->array[curr].head;
    while (temp != NULL)
    {
      int adjVertex = temp->dest;
      queue[rear++] = adjVertex;
      temp = temp->next;
    }
  }
  free(queue);
}

void printConnectedComponents(Graph *graph)
{
  int n = graph->v;
  int *visited = (int *)malloc(n * sizeof(int));
  for (int i = 0; i < n; i++)
  {
    visited[i] = 0;
  }
  printf("Connected components: \n");
  for (int i = 0; i < n; i++)
  {
    if (visited[i] != 1)
    {
      BFS(graph, visited, i);
      printf("\n");
    }
  }
}

void dfs_traverse(Graph *graph, int v, int *visited, int *stack, int *index)
{
  visited[v] = 1;
  node *temp = graph->array[v].head;
  while (temp != NULL)
  {
    int adj = temp->dest;
    if (visited[adj] != 1)
    {
      dfs_traverse(graph, adj, visited, stack, index);
    }
    temp = temp->next;
  }
  // printf("%d ", v);
  stack[(*index)++] = v;
}

void DFS(Graph *graph, int *stack)
{
  int n = graph->v;
  int *visited = (int *)calloc(n, sizeof(int));
  int index = 0;
  for (int i = 0; i < n; i++)
  {
    if (visited[i] != 1)
    {
      dfs_traverse(graph, i, visited, stack, &index);
    }
  }
  free(visited);
}

void printTopologicalOrder(Graph *graph)
{
  int n = graph->v;
  int *stack = (int *)calloc(n, sizeof(int));
  DFS(graph, stack);
  for (int i = n - 1; i >= 0; i--)
  {
    printf("%d ", stack[i]);
  }
  free(stack);
}

int main()
{
  printf("Hello World!!!\n");
  int vertices = 5;
  struct Graph *graph = createGraph(vertices);

  addEdge(graph, 0, 1);
  addEdge(graph, 1, 2);
  addEdge(graph, 3, 1);
  addEdge(graph, 3, 2);

  printGraph(graph);
  printf("Topological Order: ");
  printTopologicalOrder(graph);

  return 0;
}
