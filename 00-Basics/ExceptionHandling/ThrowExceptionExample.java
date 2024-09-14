package ExceptionHandling;
public class ThrowExceptionExample {
  public void checkAge(int age)
  {
    if(age<18)
    {
      throw new IllegalArgumentException("Age should be greater than 18");
    }
  }

  public static void main(String a[])
  {
    ThrowExceptionExample obj=new ThrowExceptionExample();
    try{
      obj.checkAge(12);
    }
    catch(IllegalArgumentException e)
    {
      System.err.println(e);
    }
  }
}
