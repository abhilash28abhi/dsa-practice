package stacks;

import java.util.Stack;

/**
 * Given string str, we need to print the reverse of individual words
 * Input : Hello World
 * Output : olleH dlroW
 *
 * Input : Geeks for Geeks
 * Output : skeeG rof skeeG
 */
public class _2_ReverseWords {

    public static void main(String[] args) {
        String str = "Hello World";
        reverseWords(str);
        System.out.println();
        System.out.println("Space efficient approach result :");
        spaceEfficientReverseWords(str);
    }

    //TC is O(n)
    //SC is O(n)
    private static void spaceEfficientReverseWords(String str) {
        //iterate over the words and push to stack until there is a space char
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) != ' ') {
                stack.push(str.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    //TC is O(N * m); N is no of words in string, m is length of each word
    //SC is O(m)
    private static void reverseWords(String str) {
        String[] arr = str.split(" ");
        Stack<Character> stack = new Stack<>();
        for (String word : arr) {
            for (char ch : word.toCharArray()) {
                stack.push(ch);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.print(" ");
        }
    }
}
