public class linearSearch {
  public static void main(String []args)
  {
    int arr[]={1,2,3,4,5,6,7,8};
    int key=6;
    int index=linear_search(arr,key);
    if(index!=-1)
    {
      System.out.println("Key value present at index "+index);
    }
    else
    {
      System.out.print("Key not present in the array");
    }
  }  
  public static int linear_search(int []arr,int key)
  {
    for(int i=0;i<arr.length;i++)
    {
      if(arr[i]==key)
      {
        return i;
      }
    }
    return -1;
  } 
}
