public class SearchInRotated {

  static int searchInRotated(int nums[], int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2; // Calculate mid in each iteration

      // If the target is found at mid, return its index
      if (nums[mid] == target) {
        return mid;
      }

      // Checking if the left half is sorted
      if (nums[mid] >= nums[low]) {
        // If the target lies in the sorted left half, search there
        if (nums[mid] >= target && nums[low] <= target) {
          high = mid - 1; // Narrow search to the left half
        } else {
          low = mid + 1; // Target is in the unsorted right half
        }
      }
      // Else, the right half must be sorted
      else {
        // If the target lies in the sorted right half, search there
        if (nums[mid] <= target && nums[high] >= target) {
          low = mid + 1; // Narrow search to the right half
        } else {
          high = mid - 1; // Target is in the unsorted left half
        }
      }
    }

    // Return -1 if the target is not found
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
    int target = 0;
    int result = searchInRotated(nums, target);
    System.out.println("Target found at index: " + result);
  }
}
