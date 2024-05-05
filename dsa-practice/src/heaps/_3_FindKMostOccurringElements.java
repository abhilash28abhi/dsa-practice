package heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Given an array of N numbers and a positive integer K. The problem is to find K numbers with the most occurrences, i.e.,
 * the top K numbers having the maximum frequency. If two numbers have the same frequency then the number with a
 * larger value should be given preference. The numbers should be displayed in decreasing order of their frequencies.
 * It is assumed that the array consists of at least K numbers.
 *
 * Input: arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, K = 2
 * Output: 4 1
 * Explanation:
 * Frequency of 4 = 2, Frequency of 1 = 2
 * These two have the maximum frequency and 4 is larger than 1.
 *
 * Input: arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, K = 4
 * Output: 5 11 7 10
 * Explanation:
 * Frequency of 5 = 3, Frequency of 11 = 2, Frequency of 7 = 2, Frequency of 10 = 1
 * These four have the maximum frequency and 5 is largest among rest.
 */
public class _3_FindKMostOccurringElements {

    public static void main(String[] args) {
        int[] input = {3, 1, 4, 4, 5, 2, 6, 1};
        findKMostOccurringElement(input, 2);
        findKMostOccurringElementUsingHeap(input, 2);
    }

    //TC is O(n log n + k log n)
    //Building the frequency map (lookup): This involves iterating through the input array of size n and updating the map, which takes O(n) time.
    //Building the priority queue (pq): This involves adding all entries from the map to the priority queue. In the worst case, where all elements have distinct frequencies, this would take O(n log n) time due to the insertion operation of the priority queue.
    //Extracting the k most occurring elements: This involves k iterations of removing the maximum element from the priority queue, which takes O(k log n) time.
    //SC is O(n)
    private static void findKMostOccurringElementUsingHeap(int[] input, int k) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i : input) {
            lookup.put(i, lookup.getOrDefault(i, 0) + 1);
        }
        //use a PQ to store the entry set object where the if the values are equal find the key with large value
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? Integer.compare(o2.getKey(), o1.getKey())
                        : Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        //add elements to PQ
        lookup.entrySet().forEach(e -> pq.add(e));

        //now the root will have the element with the highest frequency based on the comparator implemented
        int count = 0;
        while (count < k) {
            System.out.println(pq.peek().getKey());
            pq.poll();
            count++;
        }
    }

    //TC is O(N * logN)
    //SC is O(N)
    private static void findKMostOccurringElement(int[] input, int k) {
        //brute force approach is to find the elements and their freq then find the top k elements
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i : input) {
            if (!lookup.containsKey(i)) {
                lookup.put(i, 1);
            } else {
                lookup.put(i, lookup.get(i) + 1);
            }
        }

        //sort the map based on freq in decreasing order
        lookup = lookup.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        //get the top k elements in desc order
        lookup.entrySet().stream().limit(k)
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey()));
    }
}
