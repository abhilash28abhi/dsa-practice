package strings;

/**
 * Given a list of words followed by two words,
 * the task is to find the minimum distance between the given two words in the list of words
 *
 * Input: S = { “the”, “quick”, “brown”, “fox”, “quick”}, word1 = “the”, word2 = “fox”
 * Output: 3
 * Explanation: Minimum distance between the words “the” and “fox” is 3
 *
 * Input: S = {“geeks”, “for”, “geeks”, “contribute”,  “practice”}, word1 = “geeks”, word2 = “practice”
 * Output: 2
 * Explanation: Minimum distance between the words “geeks” and “practice” is 2
 */
public class _2_ClosestStrings {

    public static void main(String[] args) {
        String[] input = {"geeks", "for", "geeks", "contribute",  "practice"};
        String word1 = "geeks";
        String word2 = "practice";
        findMinDistance(input, word1, word2);
    }

    //TC is O(N)
    //SC is O(1)
    private static void findMinDistance(String[] input, String word1, String word2) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(word1)) {
                startIndex = i;
            } else if (input[i].equals(word2)) {
                endIndex = i;
            }
        }
        int minDistance = endIndex - startIndex;
        System.out.println("Minimum distance between the 2 words is : " + minDistance);
    }
}
