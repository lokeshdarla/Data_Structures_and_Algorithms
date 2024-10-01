public class MaxSubArray {

  static int maxSubArray(int nums[]) {
    int currentSum = 0;
    int maxSum = Integer.MIN_VALUE;

    int n = nums.length;

    for (int i = 0; i < n; i++) {
      currentSum += nums[i];
      maxSum = Math.max(currentSum, maxSum);
      if (currentSum < 0) {
        currentSum = 0;
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    MaxSubArray solution = new MaxSubArray();

    int[] test1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println("Max SubArray Sum (Test 1): " + solution.maxSubArray(test1));

    int[] test2 = { 1 };
    System.out.println("Max SubArray Sum (Test 2): " + solution.maxSubArray(test2));

    int[] test3 = { 5, 4, -1, 7, 8 };
    System.out.println("Max SubArray Sum (Test 3): " + solution.maxSubArray(test3));
  }
}
