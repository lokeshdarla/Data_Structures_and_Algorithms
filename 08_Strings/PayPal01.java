
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PayPal {

    public static String generateSmallestString(int n, int k, Set<Character> missingChars) {

        char[] sortedMissingChars = missingChars.stream()
                                                .sorted()
                                                .mapToCharArray();

        StringBuilder smallestString = new StringBuilder();
        smallestString.append('a'); 

        for (char c : sortedMissingChars) {
            smallestString.append(c);
        }

        while (smallestString.length() < n) {
            smallestString.append('a');
        }

        smallestString.setLength(n);

        String resultString = smallestString.toString();

        int numCopies = (int) Math.ceil((double) n / k);

        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < numCopies; i++) {
            generatedString.append(resultString);
        }

        for (char c : sortedMissingChars) {
            if (!generatedString.toString().contains(Character.toString(c))) {
                return "-1";
            }
        }

        return resultString;
    }

    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        Set<Character> missingChars = new HashSet<>(Arrays.asList('b', 'c'));

        String result = generateSmallestString(n, k, missingChars);
        System.out.println(result);
    }
}{

}
