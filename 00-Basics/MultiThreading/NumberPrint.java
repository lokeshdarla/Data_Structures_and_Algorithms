package MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NumberPrinter implements Runnable {
  private final int MAX_NUM = 10;
  private static int counter = 1;
  private final int threadID;
  private final Lock lock;
  private final Condition condition;

  public NumberPrinter(int threadId, Lock lock, Condition condition) {
    this.threadID = threadId;
    this.lock = lock;
    this.condition = condition;
  }

  @Override
  public void run() {
    try {
      lock.lock();
      while (counter < MAX_NUM) {
        while (counter % 3 != threadID) {
          condition.await();
        }
        System.out.println("Thread " + (threadID + 1) + " prints: " + counter);
        counter++;
        condition.signalAll();
      }
    } catch (InterruptedException error) {
      error.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}

public class NumberPrint {
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    Thread t1 = new Thread(new NumberPrinter(1 % 3, lock, condition));
    Thread t2 = new Thread(new NumberPrinter(2 % 3, lock, condition));
    Thread t3 = new Thread(new NumberPrinter(3 % 3, lock, condition));

    t1.start();
    t2.start();
    t3.start();
  }
}
