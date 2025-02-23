public class Equilibrium {

    public int findEquilibrium(int[] nums) {
        int n = nums.length;

        // Create prefix sum array with an extra space for easier calculations
        int pSum[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pSum[i] = pSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int leftSum = pSum[i]; // Sum from index 0 to i-1
            int rightSum = pSum[n] - pSum[i + 1]; // Sum from i+1 to n-1

            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Equilibrium eq = new Equilibrium();
        int[] nums = {1, 3, 5, 2, 2};
        System.out.println("Equilibrium Count: " + eq.findEquilibrium(nums));
    }
}
