package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Two strings str1 and str2 are called isomorphic if there is a one-to-one mapping possible for every character of str1
 * to every character of str2. And all occurrences of every character in ‘str1’ map to the same character in ‘str2’.
 *
 * Input:  str1 = “aab”, str2 = “xxy”
 * Output: True
 * Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.
 *
 * Input:  str1 = “aab”, str2 = “xyz”
 * Output: False
 * Explanation: One occurrence of ‘a’ in str1 has ‘x’ in str2 and other occurrence of ‘a’ has ‘y’.
 */
public class _3_IsomorphicStrings {

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "xxy";
        System.out.println("Are input strings isomorphic : " + areIsoMorphicStrings(str1, str2));
    }

    private static boolean areIsoMorphicStrings(String str1, String str2) {
        //use this map to store the unique char mapping for each string
        Map<Character, Character> characterMap = new HashMap<>();

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (characterMap.containsKey(str1.charAt(i))) {
                //if key of str1 exists then check the value of str2
                char value = characterMap.get(str1.charAt(i));
                if (value != str2.charAt(i)) {
                    return false;
                }
            } else if (!characterMap.containsValue(str2.charAt(i))) {
                //if map doesn't contain the key of str1 and value of str2 then only put in the map
                characterMap.put(str1.charAt(i), str2.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}
