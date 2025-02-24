import java.util.ArrayList;
import java.util.List;

public class Leaders {

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int left_max = arr[0];
        leaders.add(left_max);

        for (int i = 1; i < n; i++) {
            if (arr[i] >= left_max) {
                left_max = arr[i];
                leaders.add(left_max);
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 30, 25};
        System.out.println("Leaders: " + findLeaders(arr));
    }
}
