#include <stdio.h>
#include <stdlib.h>

int max(int a, int b)
{
  return (a > b) ? a : b;
}

int knapsack(int wt[], int val[], int n, int w)
{
  int dp[n + 1][w + 1];
  for (int i = 0; i <= n; i++)
  {
    for (int j = 0; j <= w; j++)
    {
      if (i == 0 || j == 0)
      {
        dp[i][j] = 0;
      }
      else if (wt[i - 1] <= j)
      {
        dp[i][j] = max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
      }
      else
      {
        dp[i][j] = dp[i - 1][j];
      }
    }
  }

  return dp[n][w];
}

int main()
{
  int val[] = {60, 100, 120};
  int wt[] = {10, 20, 30};
  int W = 50;
  int n = sizeof(val) / sizeof(val[0]);

  printf("Maximum value that can be obtained: %d\n", knapsack(wt, val, n, W));
  return 0;
}
