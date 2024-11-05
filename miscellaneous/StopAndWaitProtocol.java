package miscellaneous;

public class StopAndWaitProtocol {
  public static void main(String[] args) {
    int[] frames = { 1, 2, 3, 4 }; // Frame data

    for (int i = 0; i < frames.length; i++) {
      // Send frame
      System.out.println("Sending frame: " + frames[i]);

      // Simulate acknowledgement
      System.out.println("Acknowledgement received for frame: " + frames[i]);
    }
  }
}
