public class LongestCommonSubSequence {
  public static int longestCommonSubSequence(String text1, String text2) {
    char[] str1 = text1.toCharArray();
    char[] str2 = text2.toCharArray();

    int n = str1.length;
    int m = str2.length;

    // Initialize the dp array
    int[][] dp = new int[n + 1][m + 1];

    // Fill the dp table using bottom-up approach
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) { // Change i++ to j++
        if (str1[i - 1] == str2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // The result is in dp[n][m]
    return dp[n][m];
  }

  public static void main(String[] args) {
    String text1 = "Lokesh Naga Sai";
    String text2 = "lokesh";
    System.out.println(longestCommonSubSequence(text1, text2));
  }
}
