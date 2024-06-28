import java.util.Arrays;

public class searching {

  static boolean linearSearch(int[] arr, int key) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key)
        return true;
    }
    return false;
  }

  static boolean binarySearch(int[] arr, int key) {
    Arrays.sort(arr);
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == key)
        return true;
      else if (arr[mid] > key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
    int[] arr = { 1, 24, 3, 42, 5, 16, 7, 8, 9, 10 };
    System.out.println(linearSearch(arr, 9));
    System.out.println(binarySearch(arr, 1));
  }

}
