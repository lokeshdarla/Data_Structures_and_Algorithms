
class MyClass extends Thread{
  public void run(){
    System.out.println("Thread is running");
    for(int i=0;i<100;i++)
    {
      System.out.println(Thread.currentThread().getName() +" "+ i);
      try{
        Thread.sleep(1000);
      }
      catch(InterruptedException e)
      {
        System.err.println(e);
      }

    }
  }
}

public class PrintNumbers {
  
  public static void main(String a[])
  {
    MyClass t1=new MyClass();
    MyClass t2=new MyClass();
    t1.start();
    t2.start();
  }
}
