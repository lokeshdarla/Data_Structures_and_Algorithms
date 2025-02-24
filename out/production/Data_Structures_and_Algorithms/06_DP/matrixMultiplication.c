#include <stdio.h>
#include <limits.h>
#define MAX_SIZE 100

void printParenthesis(int i, int j, char *ch, int s[][MAX_SIZE])
{
  if (i == j)
  {
    printf("%c", (*ch)++);
    return;
  }
  else
  {
    printf("(");
    printParenthesis(i, s[i][j], ch, s);
    printParenthesis(s[i][j] + 1, j, ch, s);
    printf(")");
  }
}

void matrixChainOrder(int p[], int n)
{
  int m[n][n];
  int s[n][n];

  for (int i = 0; i < n; i++)
    m[i][i] = 0;

  for (int L = 2; L <= n; L++)
  {
    for (int i = 0; i < n - L + 1; i++)
    {
      int j = i + L - 1;
      m[i][j] = INT_MAX;
      for (int k = i; k < j; k++)
      {
        int q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
        if (q < m[i][j])
        {
          m[i][j] = q;
          s[i][j] = k;
        }
      }
    }
  }

  char name = 'A';
  printParenthesis(0, n - 1, &name, s);
  printf("\n");
}

int main()
{
  int n = 4;
  int p[MAX_SIZE] = {10, 20, 30, 40, 50};
  matrixChainOrder(p, n);
  return 0;
}
