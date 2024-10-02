package Blind75.Arrays;

public class ContainsMaxWater {

  static int containsMaxWater(int nums[]) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    int maxArea = 0;
    while (left < right) {
      int currentArea = Math.min(nums[left], nums[right]) * (right - left);
      maxArea = Math.max(maxArea, currentArea);

      if (nums[left] < nums[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 }; // Example input
    int maxWater = containsMaxWater(heights);
    System.out.println("The maximum water that can be contained is: " + maxWater);
  }

}
