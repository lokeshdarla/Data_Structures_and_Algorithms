package ExceptionHandling;
public class MultiCatchBlockExample {
  public static void main(String a[])
  {
    try{
      int [] arr=new int[5];
    arr[10]=20;
    }
    catch(ArithmeticException e)
    {
      System.err.println(e);
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      System.err.println(e);
    }
    catch(Exception e)
    {
      System.err.println(e);
    }
    
  }
}
