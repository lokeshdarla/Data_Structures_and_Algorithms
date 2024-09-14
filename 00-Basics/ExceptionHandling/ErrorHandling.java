package ExceptionHandling;
public class ErrorHandling {
  public static void main(String a[])
  {
    try{
      int result=10/0;
      System.out.println(result);
    }
    catch(ArithmeticException e){
      System.err.println(e);
    }
    finally{
      System.out.println("This block will execute always");
    }
  }  
}
