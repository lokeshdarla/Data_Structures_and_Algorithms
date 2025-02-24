#include <stdio.h>
#include <stdlib.h>

typedef struct Job
{
  int id;
  int deadline;
  int profit;
} job;

void swap(job *j1, job *j2)
{
  job temp = *j1;
  *j1 = *j2;
  *j2 = temp;
}

int maxDeadline(job arr[], int n)
{
  int deadline = arr[0].deadline;
  for (int i = 0; i < n; i++)
  {
    if (arr[i].deadline > deadline)
    {
      deadline = arr[i].deadline;
    }
  }
  return deadline;
}

void bubbleSort(job arr[], int n)
{
  for (int i = 0; i < n - 1; i++)
  {
    for (int j = i + 1; j < n; j++)
    {
      if (arr[i].profit > arr[j].profit)
      {
        swap(&arr[i], &arr[j]);
      }
    }
  }
}

void jobSequencing(job arr[], int n)
{
  int maxdeadline = maxDeadline(arr, n);
  bubbleSort(arr, n);

  int scheduledOrder[maxdeadline];
  for (int i = 0; i < maxdeadline; i++)
  {
    scheduledOrder[i] = -1;
  }

  int totalProfit = 0;
  for (int i = 0; i < n; i++)
  {
    for (int j = arr[i].deadline - 1; j >= 0; j--)
    {
      if (scheduledOrder[j] == -1)
      {
        scheduledOrder[j] = arr[i].id;
        totalProfit += arr[i].profit;
        break;
      }
    }
  }

  printf("Job Sequence: ");
  for (int i = 0; i < maxdeadline; i++)
  {
    if (scheduledOrder[i] != -1)
      printf("%d ", scheduledOrder[i]);
  }
  printf("\nTotal Profit: %d\n", totalProfit);
}

int main()
{
  job arr[] = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
  int n = sizeof(arr) / sizeof(arr[0]);
  jobSequencing(arr, n);
  return 0;
}
