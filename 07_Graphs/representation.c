#include <stdio.h>
#include <stdlib.h>

struct Node
{
  int dest;
  struct Node *next;
};

struct adjList
{
  struct Node *head;
};

struct Graph
{
  int V;
  struct adjList *array;
};

struct Node *NewNode(int dest)
{
  struct Node *newnode = (struct Node *)malloc(sizeof(struct Node));
  newnode->next = NULL;
  newnode->dest = dest;
  return newnode;
}

struct Graph *createGraph(int V)
{
  struct Graph *graph = (struct Graph *)malloc(sizeof(struct Graph));
  graph->V = V;
  graph->array = (struct adjList *)malloc(V * sizeof(struct adjList));
  for (int i = 0; i < V; i++)
  {
    graph->array[i].head = NULL;
  }
  return graph;
}

void addEdge(struct Graph *graph, int source, int dest)
{
  struct Node *newnode = NewNode(dest);
  newnode->next = graph->array[source].head;
  graph->array[source].head = newnode;

  struct Node *newnode2 = NewNode(source);
  newnode2->next = graph->array[dest].head;
  graph->array[dest].head = newnode2;
}

void printGraph(struct Graph *graph)
{
  int v = graph->V;
  for (int i = 0; i < v; i++)
  {
    struct Node *head = graph->array[i].head;
    printf("\n Adjacency list of vertex %d\n head ", i);
    while (head)
    {
      printf(" -> %d", head->dest);
      head = head->next;
    }
    printf("\n");
  }
}

void dfs_traverse(struct Graph *graph, int visited[], int start)
{
  visited[start] = 1;
  printf("%d ", start);
  struct Node *head = graph->array[start].head;
  while (head)
  {
    int adjVertex = head->dest;
    if (visited[adjVertex] != 1)
    {
      dfs_traverse(graph, visited, adjVertex);
    }
    head = head->next;
  }
}

void DFS(struct Graph *graph, int start)
{
  int n = graph->V;
  int *visited = (int *)malloc(n * sizeof(int));
  for (int i = 0; i < n; i++)
    visited[i] = 0;
  dfs_traverse(graph, visited, start);
  free(visited);
}

void BFS(struct Graph *graph, int start, int *visited)
{
  int n = graph->V;
  int *queue = (int *)malloc(n * sizeof(int));
  int front = 0, rear = 0;
  visited[start] = 1;
  queue[rear++] = start;
  while (front < rear)
  {
    int curr = queue[front++];
    printf("%d ", curr);
    struct Node *temp = graph->array[curr].head;
    while (temp)
    {
      int adjvertex = temp->dest;
      if (visited[adjvertex] != 1)
      {
        visited[adjvertex] = 1;
        queue[rear++] = adjvertex;
      }
      temp = temp->next;
    }
  }
  free(queue);
}

void printConnectedComponents(struct Graph *graph)
{
  int n = graph->V;
  int *visited = (int *)calloc(graph->V, sizeof(int));
  printf("Connected Components: \n");
  for (int i = 0; i < n; i++)
  {
    if (!visited[i])
    {
      BFS(graph, i, visited);
      printf("\n");
    }
  }
}

int main()
{
  int vertices = 5;
  struct Graph *graph = createGraph(vertices);

  addEdge(graph, 1, 0);
  addEdge(graph, 2, 1);
  addEdge(graph, 3, 4);

  // DFS(graph, 1);
  // printf("\n");
  // BFS(graph, 1);
  printConnectedComponents(graph);

  return 0;
}
