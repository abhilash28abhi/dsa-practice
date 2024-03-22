package strings;

import java.util.Set;
import java.util.TreeSet;

/**
 * A pangram is a sentence containing every letter in the English Alphabet.
 * Input: “The quick brown fox jumps over the lazy dog”
 * Output: is a Pangram
 * Explanation: Contains all the characters from ‘a’ to ‘z’]
 *
 * Input: “The quick brown fox jumps over the dog”
 * Output: is not a Pangram
 * Explanation: Doesn’t contain all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing
 */
public class _4_PangramString {

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";
        System.out.println("Input is a Pangram : " + isPangram(input));
    }

    private static boolean isPangram(String input) {
        Set<Character> uniqueCharSet = new TreeSet<>();
        char[] charArr = input.toLowerCase().toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if ((charArr[i] >= 'a' && charArr[i] <= 'z') && !uniqueCharSet.contains(charArr[i])) {
                uniqueCharSet.add(charArr[i]);
            }
        }
        return (uniqueCharSet.size()) == 26 ? true : false;
    }
}
