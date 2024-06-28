public class variables {
  public static void main(String[] args) {
    // Primitive Data Types
    int age = 30; // Integer
    double height = 5.9; // Double
    char gender = 'M'; // Character - Support unicode
    boolean isStudent = true; // Boolean
    byte num = 100; // Byte
    short population = 5000; // Short
    long populationOfCountry = 123456789L; // Long
    float pi = 3.14f; // Float

    // Reference Data Types
    String name = "John"; // String
    int[] numbers = { 1, 2, 3, 4 }; // Array

    // Output
    System.out.println("Age: " + age);
    System.out.println("Height: " + height);
    System.out.println("Gender: " + gender);
    System.out.println("Is Student? " + isStudent);
    System.out.println("Number: " + num);
    System.out.println("Population: " + population);
    System.out.println("Population of Country: " + populationOfCountry);
    System.out.println("Value of PI: " + pi);
    System.out.println("Name: " + name);
    System.out.print("Numbers: ");
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");
    }
  }
}
