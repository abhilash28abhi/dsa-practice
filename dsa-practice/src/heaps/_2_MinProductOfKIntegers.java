package heaps;

import java.util.PriorityQueue;

/**
 * Given an array of n positive integers. We are required to write a program to print the minimum product of k integers of the given array
 *
 * Input : 198 76 544 123 154 675
 *          k = 2
 * Output : 9348
 * We get minimum product after multiplying
 * 76 and 123.
 * Input : 11 8 5 7 5 100
 *         k = 4
 * Output : 1400
 */
public class _2_MinProductOfKIntegers {

    public static void main(String[] args) {
        int[] input = {198, 76, 544, 123, 154, 675};
        System.out.println("Min product of k integers is : " + minProduct(input, 2));
    }

    //TC is O(N * logN)
    //SC is O(N)
    private static int minProduct(int[] input, int k) {
        //use a min heap queue to find the k elements and then multiply them
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        int product = 1;
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }

        while (!pq.isEmpty() && count < k) {
            product = product * pq.peek();
            pq.poll();
            count++;
        }
        return product;
    }
}
