import java.util.*;

public class GenerateAllPermutations {

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    recurPermute(0, nums, result);
    return result;
  }

  public static void recurPermute(int index, int[] nums, List<List<Integer>> result) {
    if (index == nums.length) { // Base case: all elements are fixed
      List<Integer> permutation = new ArrayList<>();
      for (int num : nums) {
        permutation.add(num);
      }
      result.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = index; i < nums.length; i++) {
      swap(index, i, nums);  // Swap to create a new permutation
      recurPermute(index + 1, nums, result); // Recur for next index
      swap(index, i, nums);  // Backtrack to restore original array
    }
  }

  public static void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    List<List<Integer>> permutations = permute(nums);

    System.out.println("All Permutations:");
    for (List<Integer> perm : permutations) {
      System.out.println(perm);
    }
  }
}
