#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int min(int a, int b)
{
    return a < b ? a : b;
}

int main()
{
    int n = 3;
    int coins[5] = {1, 2, 3};
    int sum = 17;
    int dp[n + 1][sum + 1];
    int chosenCoins[sum + 1];

    for (int i = 0; i < n + 1; i++)
    {
        for (int j = 0; j < sum + 1; j++)
        {
            if (j == 0)
            {
                dp[i][j] = 0;
            }
            else
            {
                dp[i][j] = INT_MAX - 1;
            }
        }
    }

    for (int i = 1; i < n + 1; i++)
    {
        for (int j = 1; j < sum + 1; j++)
        {
            if (j >= coins[i - 1])
            {
                dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                if (dp[i][j] == 1 + dp[i][j - coins[i - 1]])
                {
                    chosenCoins[j] = coins[i - 1];
                }
            }
            else
            {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    printf("Minimum number of coins: %d\n", dp[n][sum]);
    printf("Coins combination: ");
    int remaining = sum;
    while (remaining > 0)
    {
        printf("%d ", chosenCoins[remaining]);
        remaining -= chosenCoins[remaining];
    }
    printf("\n");

    return 0;
}
