import java.util.HashMap;

public class TwoSum {

  public static int[] twoSum(int nums[], int target) {
    HashMap<Integer, Integer> hMap = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int compliment = target - nums[i];

      if (hMap.containsKey(compliment)) {
        return new int[] { i, hMap.get(compliment) };
      }

      hMap.put(nums[i], i);
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] a) {
    int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
    int result[] = twoSum(arr, 10);
    System.out.println(result[0]);
    System.out.println(result[1]);
  }
}
