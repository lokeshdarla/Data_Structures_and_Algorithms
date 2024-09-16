
class Mobile{
  String name;
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  int price;
  String brand;

  public static void display(Mobile obj)
  {
    System.out.println(obj.brand+" "+obj.price+" "+obj.name);
  }
}

public class StaticDemo {
  public static void main(String a[])
  {
    Mobile obj=new Mobile();
    obj.brand="Apple";
    obj.price=1200;
    obj.name="JDBfgsdigb";

    Mobile.display(obj);
  }
}
