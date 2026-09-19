package vamsilabs.dsapractice.arraysAndhashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 *
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 *
 * Output: [1]
 *
 * Example 3:
 *
 * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
 *
 * Output: [1,2]
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3}; int k = 2;
        topKFrequent2(nums, k);
    }

    // TC O(n) SC O(n)
    //efficient approach since we are getting rid of the sort operations
    //using bucket sort approach where the index of the bucket represents the frequency of the elements
    //the bucket array will have the frequency as the index
    //which means the highest frequency will be at the end of the bucket array and the lowest frequency will be at the start of the bucket array
    //making it easier to get the top k freq elements
    private static void topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(entry.getKey());
        }

        List<Integer> output = new ArrayList<>();

        for (int i = buckets.length - 1; i >= 0 && output.size() < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    output.add(num);

                    if (output.size() == k) {
                        break;
                    }
                }
            }
        }

        System.out.println(output);
    }

    //TC is O(n log n) SC is O(n)
    private static void topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : nums) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }

        List<Integer> output = countMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(output);
    }
}
