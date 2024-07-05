import java.util.ArrayList;

public class FindUnion {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (nums.isEmpty() || nums.get(nums.size() - 1) != arr1[i]) {
                    nums.add(arr1[i]); 
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (nums.isEmpty() || nums.get(nums.size() - 1) != arr2[j]) {
                    nums.add(arr2[j]); 
                }
                j++;
            } else {
                if (nums.isEmpty() || nums.get(nums.size() - 1) != arr1[i]) {
                    nums.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (nums.isEmpty() || nums.get(nums.size() - 1) != arr1[i]) {
                nums.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (nums.isEmpty() || nums.get(nums.size() - 1) != arr2[j]) {
                nums.add(arr2[j]);
            }
            j++;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};
        ArrayList<Integer> result = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Union of the two arrays: " + result); 
    }
}
