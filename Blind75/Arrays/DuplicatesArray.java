package Blind75.Arrays;

import java.util.HashSet;
import java.util.Arrays;

public class DuplicatesArray {

  static boolean isContainArray1(int nums[]) {
    HashSet<Integer> hSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (hSet.contains(nums[i])) {
        return true;
      }
      hSet.add(nums[i]);
    }
    return false;
  }

  static boolean isContainArray2(int nums[]) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] a) {
    int nums[] = { 1, 2, 3, 4, 5, 6, 7, 1 };
    System.out.println(isContainArray1(nums));
    System.out.println(isContainArray2(nums));
  }
}
