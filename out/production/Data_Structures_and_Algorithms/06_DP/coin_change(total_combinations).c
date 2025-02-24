#include<stdio.h>
// Total number of combinations
int main() {
    int n = 5;
    int coins[5] = {1, 2, 3, 4, 5};
    int sum = 6;
    int dp[n + 1][sum + 1];

    for (int i = 0; i < n + 1; i++) {
        for (int j = 0; j < sum + 1; j++) {
            if (j == 0) {
                dp[i][j] = 1; 
            } else {
                dp[i][j] = 0;
            }
        }
    }

    for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < sum + 1; j++) {
            if (j >= coins[i - 1]) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    printf("%d", dp[n][sum]);
    return 0;
}
