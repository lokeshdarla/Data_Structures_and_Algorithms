package ExceptionHandling;
class CustomException extends Exception{
  public CustomException(String message)
  {
    super(message);
  }
}

public class CustomExceptionExample {

  public static void checkAge(int age) throws CustomException
  {
    if(age<18)
    {
      throw new CustomException("Age should be greater than 18");
    }
    
  }
  public static void main(String a[])
  {
    try{
        checkAge(17);
    }
    catch(CustomException e)
    {
      System.err.println(e);
    }

  }
}
