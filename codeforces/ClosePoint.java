import java.util.Scanner;

class ClosePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine(); 

            int[] arr = new int[n];

            
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sc.nextLine(); 

            if (n > 2) {
                System.out.println("NO");
            } else {
                int difference = Math.abs(arr[0] - arr[1]);
                if (difference > 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}
