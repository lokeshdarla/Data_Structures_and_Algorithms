package Blind75.DP;

public class CoinChange {
  static int minCoins(int[] coins, int amount) {
    int dp[] = new int[amount + 1];
    for (int i = 0; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        // i-> current amount
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    int[] coins = { 1, 2, 5 };
    System.out.println(minCoins(coins, 11));
  }
}
