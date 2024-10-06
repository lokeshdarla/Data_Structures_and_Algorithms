package Blind75.DP;

public class LongestIncreasingSubsequence {
  static int longestIncreasingSubsequence(int nums[]) {
    int n = nums.length;
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int result = 0;
    for (int length : dp) {
      result = Math.max(length, result);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println("Longest Increasing Subsequences");

    int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
    System.out.println(longestIncreasingSubsequence(nums));
  }
}
