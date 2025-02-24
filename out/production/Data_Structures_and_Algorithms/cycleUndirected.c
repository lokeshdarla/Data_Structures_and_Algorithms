#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
  int dest;
  struct Node *next;
} node;

typedef struct AdjList
{
  struct Node *head;
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

void addEdge(Graph *graph, int src, int dest)
{
  node *newnode = createNode(dest);
  newnode->next = graph->array[src].head;
  graph->array[src].head = newnode;

  newnode = createNode(src);
  newnode->next = graph->array[dest].head;
  graph->array[dest].head = newnode;
}

int isCyclicUtil(Graph *graph, int *visited, int v, int parent)
{
  visited[v] = 1;
  node *temp = graph->array[v].head;
  while (temp != NULL)
  {
    int adj = temp->dest;
    if (!visited[adj])
    {
      if (isCyclicUtil(graph, visited, adj, v))
      {
        return 1;
      }
    }
    else if (adj != parent)
    {
      return 1;
    }
    temp = temp->next;
  }
  return 0;
}

int isCyclic(Graph *graph)
{
  int *visited = (int *)calloc(graph->v, sizeof(int));
  for (int i = 0; i < graph->v; i++)
  {
    if (!visited[i])
    {
      if (isCyclicUtil(graph, visited, i, -1))
      {
        free(visited);
        return 1;
      }
    }
  }
  free(visited);
  return 0;
}

int main()
{
  int V = 4;
  Graph *graph = createGraph(V);
  addEdge(graph, 0, 1);
  addEdge(graph, 1, 2);
  addEdge(graph, 2, 3);
  addEdge(graph, 3, 0);

  if (isCyclic(graph))
    printf("Graph contains a cycle\n");
  else
    printf("Graph does not contain a cycle\n");

  return 0;
}
