package strings;

/**
 * Given a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by
 * deleting some characters of the given ‘str’.
 * Input : dict = {"ale", "apple", "monkey", "plea"}
 *         str = "abpcplea"
 * Output : apple
 *
 * Input  : dict = {"pintu", "geeksfor", "geeksgeeks", " forgeek"}
 *          str = "geeksforgeeks"
 * Output : geeksgeeks
 */
public class _5_LargestWordInDictionary {

    public static void main(String[] args) {
        String[] dictionary = {"ale", "apple", "monkey", "plea"};
        String word = "abpcplea";
        System.out.println("The longest word in dictionary formed is :  " + findLongestWord(dictionary, word));
    }

    //TC is O(N*(K+M)), N is length of dictionary array and M is length of the input word, K is length of each string in dictionary
    //SC is O(K); K is the max length of a word in dictionary
    private static String findLongestWord(String[] dictionary, String word) {
        //iterate over the dictionary and see if that string is a subsequence of word
        //if yes, then return the subsequence word with max length
        String longestWord = "";
        for (String str : dictionary) {
            String subSequenceWord = isSubsequence(str, word);
            if (null != subSequenceWord && subSequenceWord.length() >= longestWord.length()) {
                longestWord = subSequenceWord;
            }
        }
        return longestWord;
    }

    private static String isSubsequence(String str, String word) {
        int j = 0;
        for (int i = 0; i < word.length() && j < str.length(); i++) {
            if (word.charAt(i) == str.charAt(j)) {
                j++;
            }
        }
        if (j == str.length()) {
            //means that str is a subsequence of word
            return str;
        }
        return null;
    }
}
