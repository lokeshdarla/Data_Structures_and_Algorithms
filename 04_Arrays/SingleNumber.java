public class SingleNumber {

  public int singleNumber(int[] nums) {
      int key = nums[0];
      for (int i = 1; i < nums.length; i++) {
          key = key ^ nums[i];
      }
      return key;
  }

  public static void main(String[] args) {
    SingleNumber solution = new SingleNumber();
      
      int[] nums1 = {2, 2, 1};
      System.out.println("Single number in array {2, 2, 1}: " + solution.singleNumber(nums1)); // Output: 1
      
      int[] nums2 = {4, 1, 2, 1, 2};
      System.out.println("Single number in array {4, 1, 2, 1, 2}: " + solution.singleNumber(nums2)); // Output: 4
      
      int[] nums3 = {1};
      System.out.println("Single number in array {1}: " + solution.singleNumber(nums3)); // Output: 1
  }
}
