#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct Node
{
  int dest;
  int weight;
  struct Node *next;
} node;

typedef struct AdjList
{
  node *head;
} adjList;

typedef struct Graph
{
  int v;
  adjList *array;
} Graph;

node *crreateNode(int dest, int weight)
{
  node *newnode = (node *)malloc(sizeof(node));
  newnode->dest = dest;
  newnode->weight = weight;
  newnode->next = NULL;
  return newnode;
}

Graph *createGraph(int v)
{
  Graph *graph = (Graph *)malloc(sizeof(Graph));
  graph->v = v;
  graph->array = (adjList *)malloc(v * sizeof(adjList));
  for (int i = 0; i < v; i++)
  {
    graph->array[i].head = NULL;
  }

  return graph;
}

void addEdge(Graph *graph, int src, int dest, int weight)
{
  node *newnode = crreateNode(dest, weight);
  newnode->next = graph->array[src].head;
  graph->array[src].head = newnode;
}

void printWeightedGraph(Graph *graph)
{
  int n = graph->v;
  for (int i = 0; i < n; i++)
  {
    node *temp = graph->array[i].head;
    printf("Adjacency List from vertex %d: ", i);
    while (temp != NULL)
    {
      printf("(%d, %d) ", temp->dest, temp->weight);
      temp = temp->next;
    }
    printf("\n");
  }
}

void printDistances(int dist[], int n)
{
  printf("Vertex Distance from Source\n");
  for (int i = 0; i < n; ++i)
    printf("%d \t %d\n", i, dist[i]);
}

void BellmanFord(Graph *graph, int src)
{
  int n = graph->v;
  int *dist = (int *)malloc(n * sizeof(int));
  for (int i = 0; i < n; i++)
  {
    dist[i] = INT_MAX;
  }
  dist[src] = 0;
  for (int i = 1; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      node *temp = graph->array[j].head;
      while (temp != NULL)
      {
        int u = j;
        int v = temp->dest;
        int weight = temp->weight;
        if (dist[u] != INT_MAX && dist[u] + weight < dist[v])
        {
          dist[v] = dist[u] + weight;
        }
        temp = temp->next;
      }
    }
  }

  for (int i = 0; i < n; i++)
  {

    node *temp = graph->array[i].head;
    while (temp != NULL)
    {
      int u = i;
      int v = temp->dest;
      int weight = temp->weight;
      if (dist[i] != INT_MAX && dist[u] + weight < dist[v])
      {
        printf("Graph contains negative weight cycle\n");
        return;
      }
      temp = temp->next;
    }
  }
  printDistances(dist, n);
}

int main()
{
  int V = 5;
  Graph *graph = createGraph(V);
  addEdge(graph, 0, 1, 5);
  addEdge(graph, 0, 2, 3);
  addEdge(graph, 1, 3, 6);
  addEdge(graph, 1, 2, 2);
  addEdge(graph, 2, 4, 4);
  addEdge(graph, 4, 3, 1);

  // printWeightedGraph(graph);
  BellmanFord(graph, 0);

  return 0;
}
