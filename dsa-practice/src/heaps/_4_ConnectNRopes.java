package heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost,
 * such that the cost to connect two ropes is equal to the sum of their lengths.
 *
 * Input: arr[] = {4,3,2,6} , N = 4
 * Output: 29
 * Explanation:
 * (3,2)-->5 we have 4, 5, 6 now (4,5)--> 9 we have 9, 6 now (9,6)-->15, so sum is 15+9+5=24 which is the min
 *
 * Input: arr[] = {1, 2, 3} , N = 3
 * Output: 9
 */
public class _4_ConnectNRopes {

    public static void main(String[] args) {
        int[] input = {4,3,2,6};
        System.out.println("Cost of connecting N ropes with minimum cost is : " + costOfNRopes(input));
    }

    //TC is O(N * log N)
    //SC us O(N)
    private static int costOfNRopes(int[] input) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int  i : input) {
            pq.add(i);
        }

        int minCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            minCost = minCost + cost;
            pq.add(cost);
        }
        return minCost;
    }
}
