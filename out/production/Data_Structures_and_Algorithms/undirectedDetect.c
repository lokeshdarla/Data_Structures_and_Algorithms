#include <stdio.h>
#include <stdlib.h>

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

// Function to create a new node
node *createNode(int dest, int weight)
{
  node *newNode = (node *)malloc(sizeof(node));
  newNode->dest = dest;
  newNode->weight = weight;
  newNode->next = NULL;
  return newNode;
}

// Function to create a graph with 'v' vertices
Graph *createGraph(int v)
{
  Graph *graph = (Graph *)malloc(sizeof(Graph));
  graph->v = v;
  graph->array = (adjList *)malloc(v * sizeof(adjList));
  for (int i = 0; i < v; ++i)
    graph->array[i].head = NULL;
  return graph;
}

// Function to add an edge to the graph
void addEdge(Graph *graph, int src, int dest, int weight)
{
  node *newNode = createNode(dest, weight);
  newNode->next = graph->array[src].head;
  graph->array[src].head = newNode;
}

// DFS recursive function
int isCyclicUtil(int v, int visited[], int recStack[], Graph *graph)
{
  if (visited[v] == 0)
  {
    visited[v] = 1;
    recStack[v] = 1;

    node *temp = graph->array[v].head;
    while (temp != NULL)
    {
      int adjNode = temp->dest;
      if (!visited[adjNode] && isCyclicUtil(adjNode, visited, recStack, graph))
        return 1;
      else if (recStack[adjNode])
        return 1;
      temp = temp->next;
    }
  }
  recStack[v] = 0;
  return 0;
}

// Function to detect cycles in the graph using DFS
int isCyclic(Graph *graph)
{
  int *visited = (int *)calloc(graph->v, sizeof(int));
  int *recStack = (int *)calloc(graph->v, sizeof(int));

  for (int i = 0; i < graph->v; ++i)
    if (isCyclicUtil(i, visited, recStack, graph))
      return 1;

  return 0;
}

int main()
{
  int v, e;
  printf("Enter the number of vertices and edges: ");
  scanf("%d %d", &v, &e);

  Graph *graph = createGraph(v);

  printf("Enter the edges (source destination weight):\n");
  for (int i = 0; i < e; i++)
  {
    int src, dest, weight;
    scanf("%d %d %d", &src, &dest, &weight);
    addEdge(graph, src, dest, weight);
  }

  if (isCyclic(graph))
    printf("Graph contains cycle.\n");
  else
    printf("Graph doesn't contain cycle.\n");

  return 0;
}
