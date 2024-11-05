interface A {
  void run();
}

class B implements A {
  public void hello() {
    System.out.println("Hello World");
  }

  @Override
  public void run() {
    System.out.println("From overriding function");
  }
}

public class InterfaceExample {
  public static void main(String[] args) {
    B obj = new B();
    obj.hello();
    System.out.println("Hello Class");
  }
}
