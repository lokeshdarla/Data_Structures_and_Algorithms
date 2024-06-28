import java.util.Scanner;

class Pen {
  String name;
  String color;

  Pen(String name, String color) {
    System.out.println("Constructor called");
    this.name = name;
    this.color = color;
  }

  public void printName() {
    System.out.println("Name : " + this.name);
  }

  public void printColor() {
    System.out.println("Color : " + this.color);
  }
}

public class OOPS {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter pen name: ");
    String penName = scanner.nextLine();

    System.out.print("Enter pen color: ");
    String penColor = scanner.nextLine();

    Pen pen1 = new Pen(penName, penColor);

    pen1.printColor();
    pen1.printName();

    scanner.close();
  }
}
