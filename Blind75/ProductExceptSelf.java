public class ProductExceptSelf {
  static int[] productExceptSelf(int nums[]) {
    int n = nums.length;
    int result[] = new int[n];

    int leftProduct = 1;
    for (int i = 0; i < n; i++) {
      result[i] = leftProduct;
      leftProduct *= nums[i];
    }

    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] = result[i] * rightProduct;
      rightProduct *= nums[i];
    }

    return result;
  }

  public static void main(String[] a) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    int result[] = productExceptSelf(nums);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }

  }
}
