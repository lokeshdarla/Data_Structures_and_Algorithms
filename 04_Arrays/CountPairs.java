public class CountPairs {

    public static int countPairs(char[] arr) {
        int n = arr.length;
        int cg = 0;
        int p = 0;


        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'g') {
                cg++;
            } else if (arr[i] == 'a') {
                p += cg;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'g', 'a', 'g', 'g'};
        System.out.println("Count of pairs: " + countPairs(arr));
    }
}
