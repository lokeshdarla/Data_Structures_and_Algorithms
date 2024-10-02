package Blind75.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int nums[]) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    int n = nums.length;

    for (int k = 0; k < n - 2; k++) {
      if (k > 0 && nums[k] == nums[k - 1]) {
        continue;
      }

      int target = -nums[k];
      int low = k + 1;
      int high = n - 1;

      while (low < high) {
        int sum = nums[low] + nums[high];
        if (sum == target) {
          result.add(Arrays.asList(nums[k], nums[low], nums[high]));

          while (low < high && nums[low] == nums[low + 1])
            low++;

          while (low < high && nums[high] == nums[high - 1])
            high--;

          low++;
          high--;
        } else if (sum < target) {
          low++;
        } else {
          high--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ThreeSum solution = new ThreeSum();
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    List<List<Integer>> result = solution.threeSum(nums);
    System.out.println(result);
  }
}
