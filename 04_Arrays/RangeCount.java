public class RangeCount {

    // Brute Force Approach: O(Q * (R - L + 1))
    public static int countRanges(int[] arr, int[][] B) {
        int count = 0;
        for (int[] range : B) { // Loop through each query
            int l = range[0], r = range[1];
            for (int k = l; k <= r; k++) {
                if (arr[k] % 2 == 0) { // Count even numbers
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized Approach: O(N + Q)
    public static int optimized(int[] arr, int[][] B) {
        int n = arr.length;

        // Step 1: Convert even numbers to 1, odd numbers to 0
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (arr[i] % 2 == 0 ? 1 : 0);
        }

        // Step 2: Process queries in O(1)
        int count = 0;
        for (int[] range : B) {
            int l = range[0], r = range[1];
            count += prefixSum[r + 1] - prefixSum[l];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int[][] queries = {{0, 3}, {2, 6}, {1, 7}};

        System.out.println("Brute Force Count: " + countRanges(arr, queries));
        System.out.println("Optimized Count: " + optimized(arr, queries));
    }
}
