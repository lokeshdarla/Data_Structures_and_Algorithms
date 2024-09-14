

public class StringExercise {

  public static String reverseString(String input)
  {
    return new StringBuilder(input).reverse().toString();
  }

  public static Boolean isPalindrome(String input)
  {
    String str1=new StringBuilder(input).reverse().toString();
    return str1.equals(input);
  }
  public static void main(String a[])
  {
    // String str1="Lokesh";
    // System.out.println(str1);
    // String str2=reverseString(str1);
    // System.out.println(str2);


    // To check palindrome
    // String str3="madam";
    // System.out.println("Are these Palindrome "+ isPalindrome(str3));


    // String operations
    String str="Hello World";

    System.out.println(str.length());

    System.out.println(str.charAt(4));

    System.out.println(str.substring(0, 5));
    System.out.println(str.substring(5));

    System.out.println(str.equals("Hello World"));
    System.out.println(str.equalsIgnoreCase("hello world"));
    System.out.println(str.compareTo("Hello World"));

    System.out.println(str.replaceAll("l", "k"));

    System.out.println("  Hello, World!  ".trim());



  }
}
