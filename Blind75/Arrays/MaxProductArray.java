package Blind75.Arrays;

class MaxProductArray {
  public int maxProductArray(int[] nums) {
    int n = nums.length;

    int maxProduct = nums[0];
    int currentMax = nums[0];
    int currentMin = nums[0];

    for (int i = 1; i < n; i++) {
      if (nums[i] < 0) {
        int temp = currentMax;
        currentMax = currentMin;
        currentMin = temp;
      }

      currentMax = Math.max(nums[i], currentMax * nums[i]);
      currentMin = Math.min(nums[i], currentMin * nums[i]);

      maxProduct = Math.max(maxProduct, currentMax);
    }

    return maxProduct;
  }

  public static void main(String[] args) {
    MaxProductArray solution = new MaxProductArray();

    int[] test1 = { 2, 3, -2, 4 };
    System.out.println("Max Product (Test 1): " + solution.maxProductArray(test1));

    int[] test2 = { -2, 0, -1 };
    System.out.println("Max Product (Test 2): " + solution.maxProductArray(test2));
  }
}
