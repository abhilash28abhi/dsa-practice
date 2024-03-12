package strings;

/**
 * Given a set of strings, find the longest common prefix.
 * Input: {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
 * Output: “gee”
 *
 * Input: {“apple”, “ape”, “april”}
 * Output: “ap”
 */
public class _1_LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("Longest common prefix is : " + findCommonLongestPrefix(arr));
    }

    //TC is O(N * m) where m is the length of the prefix and n is the number of strings in the input array
    private static String findCommonLongestPrefix(String[] arr) {
        String result = arr[0];

        for (int i = 1; i < arr.length; i++) {

            //means the arr[i] contains result string, so find the exact string which matches
            while (!arr[i].contains(result)) {
                //here we are trimming last char from string and seeing if it is still a match or not
                result = result.substring(0, result.length() - 1);

                if(result.isEmpty()){
                    return "-1"; //no match
                }
            }
        }
        return result;
    }
}
