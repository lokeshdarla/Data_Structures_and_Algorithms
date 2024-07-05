public class MoveZeros {
  public static void main(String []args)
  {
    int arr[]={1,0,2,0,3,0,4,0,5};
    moveZerosToEnd(arr);
    for(int i=0;i<arr.length;i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println("Hello World");
  }  

  public static void moveZerosToEnd(int []arr)
  {
    int index=0;
    for(int i=0;i<arr.length;i++)
    {
      if(arr[i]!=0)
      {
        int temp=arr[index];
        arr[index]=arr[i];
        arr[i]=temp;
        index++;
      }
    }
  }
}
