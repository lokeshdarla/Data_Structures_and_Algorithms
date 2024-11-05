package miscellaneous;

public class SlidingWindowProtocol {
  public static void main(String[] args) {
    int[] frames = { 1, 2, 3, 4, 5, 6, 7, 8 }; // Frame data
    int windowSize = 3; // Define window size
    int i = 0;

    while (i < frames.length) {
      // Send frames in the window
      System.out.print("Frames sent: ");
      for (int j = i; j < i + windowSize && j < frames.length; j++) {
        System.out.print(frames[j] + " ");
      }
      System.out.println();

      // Simulate ACK reception
      System.out.println("Acknowledgement received for frame " + frames[i]);

      // Move window
      i++;
    }
  }
}
