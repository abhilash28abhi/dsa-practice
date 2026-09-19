package vamsilabs.dsapractice.arraysAndhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 */
public class GroupAnagram {

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(input);
    }

    //TC O(n log N) SC O(n)
    private static void groupAnagrams(String[] input) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : input) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.values());
        System.out.println(result);
    }
}
