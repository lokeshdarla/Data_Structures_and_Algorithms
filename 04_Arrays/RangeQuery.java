public class RangeQuery {

    // Brute Force O(N * Q)
    public static void bruteForce(int[] arr, int[][] B) {
        for (int j = 0; j < B.length; j++) {
            int l = B[j][0], r = B[j][1];
            long sum = 0;
            for (int k = l; k <= r; k++) {
                sum += arr[k];
            }
            System.out.println(sum);
        }
    }

    // Optimized O(N + Q)
    public static void Optimised(int[] arr, int[][] B) {
        int n = arr.length;
        int[] pSum = new int[n + 1];

        // Build Prefix Sum Array
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + arr[i - 1];
        }

        // Answer Queries in O(1)
        for (int i = 0; i < B.length; i++) {
            int l = B[i][0], r = B[i][1];
            long sum = pSum[r + 1] - pSum[l];
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] queries = {{1, 3}, {0, 2}, {2, 4}};

        System.out.println("Brute Force Output:");
        bruteForce(arr, queries);

        System.out.println("Optimized Output:");
        Optimised(arr, queries);
    }
}
