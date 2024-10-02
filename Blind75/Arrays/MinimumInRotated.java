package Blind75.Arrays;

public class MinimumInRotated {

  static int minimumInRotated(int nums[]) {
    int low = 0;
    int high = nums.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] > nums[high]) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    int min = minimumInRotated(nums);
    System.out.println("Minimum element is: " + min);
  }
}
