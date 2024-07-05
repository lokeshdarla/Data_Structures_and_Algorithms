
public class RotateByKPlaces {
  public static void main(String[] args) {
    int arr[]={1,2,3,4,5,6};
    int k=2;
    left_rotate(arr, k);
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println("Hello World ");
  }

  public static void left_rotate(int arr[],int k)
  {
    int n=arr.length;
    k=k%n;
    reverse(arr, 0, k);
    reverse(arr, n-k, n-1);
    reverse(arr, 0, n-1);
  }

  public static void right_rotate(int arr[],int k)
  {
    int n=arr.length;
    k=k%n;
    reverse(arr, 0, n-1);
    reverse(arr, 0, k-1);
    reverse(arr, k, n-1);
  }

  public static void reverse(int arr[],int start,int end)
  {
    while(start<end)
    {
      int temp=arr[start];
      arr[start]=arr[end];
      arr[end]=temp;
      start++;
      end--;
    }
  }
}
