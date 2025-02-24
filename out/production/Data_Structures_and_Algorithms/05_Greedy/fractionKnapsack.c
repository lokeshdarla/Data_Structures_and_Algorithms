#include <stdio.h>
#include <stdlib.h>

struct item
{
  int value;
  int weight;
};

void swap(struct item *a, struct item *b)
{
  struct item temp = *a;
  *a = *b;
  *b = temp;
}

double fractionalKnapsack(struct item arr[], int n, int capacity)
{
  for (int i = 0; i < n - 1; i++)
  {
    for (int j = i + 1; j < n; j++)
    {
      double ratio1 = (double)arr[i].value / arr[i].weight;
      double ratio2 = (double)arr[j].value / arr[j].weight;
      if (ratio1 < ratio2)
      {
        swap(&arr[i], &arr[j]);
      }
    }
  }

  double total = 0.0;
  int current_cap = capacity;
  for (int i = 0; i < n; i++)
  {
    if (arr[i].weight <= current_cap)
    {
      total += arr[i].value;
      current_cap -= arr[i].weight;
    }
    else
    {
      total += (double)arr[i].value / arr[i].weight * current_cap;
      return total;
    }
  }
  return total;
}

int main()
{
  struct item arr[] = {{60, 10}, {100, 20}, {120, 30}};
  int n = sizeof(arr) / sizeof(arr[0]);

  int capacity = 100;
  double maxValue = fractionalKnapsack(arr, n, capacity);
  printf("Maximum value that can be obtained: %.2lf\n", maxValue);
  return 0;
}
